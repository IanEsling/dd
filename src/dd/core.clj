(ns dd.core
  (:require [dd.lda :as dd])
  (:require [dd.db :as db]))

(defn save-mps [mps]
  (when-let [mp (first mps)]
    (def mp-id (first (re-seq #"\d+$" (:_about mp))))
    (db/save-mp mp-id mp)
    (db/save-ayes mp-id (dd/ayes mp-id))
    (db/save-noes mp-id (dd/noes mp-id))
    (recur (next mps))))

(defn -main
  [& args]
  (save-mps dd/MPs))
