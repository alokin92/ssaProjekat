(ns autoprod.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [autoprod.controller :as controller]
            [autoprod.automobili :as automobili]
            [autoprod.tipautaa :as tipautaa]
            [autoprod.opreme :as opreme]
            [autoprod.ugovori :as ugovori]))

(defroutes public-routes
  (GET "/" [] (controller/index))
  (GET "/automobili" [] (controller/automobili))
  (route/resources "/")
  (GET "/automobili/new" [] (controller/new))
  (GET "/automobili/:id/delete" [id]
       (do (automobili/delete id)
        (resp/redirect "/automobili")))
  (POST "/automobili/create" [& params]
        (do (automobili/create params)
         (resp/redirect "/automobili")))
  (POST "/automobili/:regbrojauta/update" [& params]
       (do (automobili/update (:regbrojauta params) params)
         (resp/redirect "/automobili")))
  (GET "/automobili/:id/edit" [id] (controller/edit id))
  (GET "/tipautaa" [] (controller/tipautaa))
  (POST "/tipautaa/create" [& params]
        (do (tipautaa/create params)
          (resp/redirect "/tipautaa")))
  (GET "/tipautaa/:id/delete" [id]
       (do (tipautaa/delete id)
         (resp/redirect "/tipautaa")))
  (GET "/opreme" [] (controller/opreme))
  (POST "/opreme/create" [& params]
        (do (opreme/create params)
          (resp/redirect "/opreme")))
  (GET "/opreme/:id/delete" [id]
       (do (opreme/delete id)
         (resp/redirect "/opreme")))
  (GET "/ugovori" [] (controller/ugovori))
  (POST "/ugovori/create" [& params]
        (do (ugovori/create params)
          (resp/redirect "/ugovori")))
  (GET "/ugovori/:id/edit" [id] (controller/edit-ugovor id))
  (POST "/ugovori/:id/update" [& params]
        (do (ugovori/update params)
          (resp/redirect "/ugovori")))
    (GET "/ugovori/:id/delete" [id]
       (do (ugovori/delete id)
         (resp/redirect "/ugovori"))))

(defroutes app-routes 
  public-routes 
  (route/not-found "404 Not Found"))

(def app 
  (handler/site app-routes))