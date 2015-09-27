(ns autoprod.tipautaa
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/prodauta"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           (s/select * :tipauta)))

(defn get [id]
  (j/query mysql-db
           (s/select * :tipauta (s/where {:tipautaid id}))))

(defn create [params]
  (j/insert! mysql-db :tipauta params))

(defn update [id params]
  (j/update! mysql-db :tipauta params (s/where {:tipautaid id})))

(defn delete [id]
  (j/delete! mysql-db :tipauta (s/where {:tipautaid id})))



