(ns dd.db
  (:require [yesql.core :refer [defqueries]])
  (:require [cheshire.core :as ch]))

(defqueries "queries.sql")

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/dd"
              :user "postgres"
              :password "password"})

(defn- save-json-obj [save-f mp-id json]
  (save-f db-spec mp-id (ch/generate-string json)))

(defn- save-json-list [save-f mp-id json-list]
  (when-let [json (first json-list)]
    (save-json-obj save-f mp-id json)
    (recur save-f mp-id (next json-list))))

(defn save-mp [mp-id mp]
  (save-json-obj create-mp-j! mp-id mp))

(defn save-ayes [mp-id ayes]
  (save-json-list create-aye-j! mp-id ayes))

(defn save-noes [mp-id noes]
  (save-json-list create-no-j! mp-id noes))
