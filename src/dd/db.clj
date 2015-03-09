(ns dd.db
  (:require [yesql.core :refer [defqueries]])
  (:require [cheshire.core :as ch]))

(defqueries "queries.sql")

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/dd"
              :user "ian"})

(defn save-mp [mp]
  (create-mp-j! db-spec (ch/generate-string mp)))
