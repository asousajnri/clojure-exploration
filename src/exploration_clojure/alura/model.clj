(ns exploration_clojure.alura.model)

(def empty-queue clojure.lang.PersistentQueue/EMPTY)

(defn new-hospital []
  {:wait empty-queue
   :lab1 empty-queue
   :lab2 empty-queue
   :lab3 empty-queue})