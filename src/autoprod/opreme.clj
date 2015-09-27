(ns autoprod.opreme
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/prodauta"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           (s/select * :oprema)))

(defn get [id]
  (j/query mysql-db
           (s/select * :oprema (s/where {:opremaid id}))))

(defn create [params]
  (j/insert! mysql-db :oprema params))

(defn update [id params]
  (j/update! mysql-db :oprema params (s/where {:opremaid id})))

(defn delete [id]
  (j/delete! mysql-db :oprema (s/where {:opremaid id})))

