(ns dd.lda
  (:require [clj-http.client :as client])
  (:require [cheshire.core :as ch]))

(def all-mps-url "http://lda.data.parliament.uk/commonsmembers.json?_page=0&_pageSize=2000")

(def ayes-url "http://lda.data.parliament.uk/commonsdivisions/aye.json?mnisId=")

(def noes-url "http://lda.data.parliament.uk/commonsdivisions/no.json?mnisId=")

(defn items-from-url [url]
  (:items
    (:result
      (ch/parse-string (:body (client/get url))
                       true))))

(defn MPs []
  (items-from-url all-mps-url))

(defn ayes [mp-id]
  (items-from-url (str ayes-url mp-id)))

(defn noes [mp-id]
  (items-from-url (str noes-url mp-id)))