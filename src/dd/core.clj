(ns dd.core
  (:require [dd.lda :as dd])
  (:require [dd.db :as db]))

(defn save-mps [mps]
  ;(print (str "saving mp " (first mps)))
  (when-let [mp (first mps)]
    ;(print "saving mp " mp)
    (db/save-mp mp)
    (db/save-ayes (dd/ayes (first (re-seq #"\d+$" (:_about mp)))))
    (recur (next mps))))

(defn -main
  [& args]
  (print "running...")
  (save-mps dd/MPs))
