(ns dd.core
  (:require [dd.lda :as dd])
  (:require [dd.db :as db]))

(defn save-mps []
  (doall (map (fn [mp] (db/save-mp mp)) dd/MPs)))

(defn -main
  [& args]
  (save-mps))
