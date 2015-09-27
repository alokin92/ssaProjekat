(ns autoprod.controller

 (:require [clostache.parser :as clostache]
            [autoprod.automobili :as automobili]
            [autoprod.tipautaa :as tipautaa]
            [autoprod.opreme :as opreme]
            [autoprod.ugovori :as ugovori]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn automobili []
  (render-template "automobili" {:automobili (automobili/all)}))

(defn index []
  (render-template "index" {:automobili (automobili/all)}))

(defn new []
  (render-template "new_automobil" {:tipautaa (tipautaa/all)
                                 :opreme (opreme/all)}))

(defn edit [id]
  (render-template "edit_automobil" {:tipautaa (tipautaa/all)
                                  :opreme (opreme/all)
                                  :automobil (automobili/get id)}))

(defn tipautaa []
  (render-template "tipautaa" {:tipautaa (tipautaa/all)}))

(defn opreme []
  (render-template "opreme" {:opreme (opreme/all)}))


(defn ugovori []
  (render-template "ugovori" {:ugovori (ugovori/all)
                               :automobili (automobili/all)
                               :opreme (opreme/all)
                               :tipautaa (tipautaa/all)}))

(defn edit-ugovor [id]
  (render-template "edit_ugovor" {:ugovor (ugovori/get id)
                                   :automobil (automobili/get id)}))



