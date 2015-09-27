(ns autoprod.automobili
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/prodauta"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           ["select * from automobil inner join oprema on (automobil.oprema_id = oprema.opremaid) 
inner join tipauta on (automobil.tipauta_id = tipauta.tipautaid) order by regbrojauta"]))

(defn get [id]
  (first (j/query mysql-db
                  (s/select * :automobil (s/where {:regbrojauta id})))))

(defn create [params]
  (j/insert! mysql-db :automobil params))

(defn update [id params]
  (j/update! mysql-db :automobil params (s/where {:regbrojauta id})))

(defn delete [id]
  (j/delete! mysql-db :automobil (s/where {:regbrojauta id})))



