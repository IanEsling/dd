(ns dd.db
  (:require [yesql.core :refer [defqueries]])
  (:require [cheshire.core :as ch]))

(defqueries "queries.sql")

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/dd"
              :user "postgres"
              :password "password"})

(defn save-mp [mp]
  (create-mp-j! db-spec (ch/generate-string mp)))

(defn save-ayes [ayes]
  (when-let [aye (first ayes)]
    (create-aye-j! db-spec (ch/generate-string aye))))
