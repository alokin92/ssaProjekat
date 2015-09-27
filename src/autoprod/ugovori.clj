(ns autoprod.ugovori
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/prodauta"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           ["select * from ugovor join automobil on (ugovor.automobil_id = automobil.regbrojauta) join oprema on (automobil.oprema_id=oprema.opremaid) join tipauta on (automobil.tipauta_id=tipauta.tipautaid)"]))

(defn get [id]
  (first (j/query mysql-db
                  [(clojure.string/join ["select * from ugovor inner join automobil on (ugovor.automobil_id = automobil.regbrojauta) where ugovorid=", id])])))

(defn create [params]
  (j/insert! mysql-db :ugovor params))

(defn update [id params]
  (j/update! mysql-db :ugovor params (s/where {:ugovorid id})))

(defn delete [id]
  (j/delete! mysql-db :ugovor (s/where {:ugovorid id})))


