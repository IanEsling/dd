(ns dd.lda
  (:require [clj-http.client :as client])
  (:require [cheshire.core :as ch]))

(def MPs  (:items
           (:result
            (ch/parse-string (:body
                              (client/get "http://lda.data.parliament.uk/commonsmembers.json?_page=0&_pageSize=2000")) true))))

(defn ayes [mp-id]
   (:items
       (:result
         (ch/parse-string (:body
                           (client/get (str "http://lda.data.parliament.uk/commonsdivisions/aye.json?mnisId=" mp-id))) true))))

(defn noes [mp-id]
   (:items
       (:result
         (ch/parse-string (:body
                            (client/get (str "http://lda.data.parliament.uk/commonsdivisions/no.json?mnisId=" mp-id))) true))))
