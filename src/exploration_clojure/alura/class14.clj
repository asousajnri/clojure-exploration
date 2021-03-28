(ns exploration_clojure.alura.class14
  (:use [clojure.pprint])
  (:require [exploration_clojure.alura.model :as alura.model]
            [exploration_clojure.alura.logic :as alura.logic]))

(defn simulate-a-day []
  ; root binding
  (def hospital (alura.model/new-hospital))

  (def hospital (alura.logic/arrives-at hospital :wait "222"))
  (def hospital (alura.logic/arrives-at hospital :wait "222"))
  (def hospital (alura.logic/arrives-at hospital :wait "333"))
  (pprint hospital)

  (def hospital (alura.logic/arrives-at hospital :lab1 "444"))
  (def hospital (alura.logic/arrives-at hospital :lab3 "555"))
  (pprint hospital)

  (def hospital (alura.logic/meets hospital :wait))
  (def hospital (alura.logic/meets hospital :lab1))
  (pprint hospital)

  (def hospital (alura.logic/arrives-at hospital :wait "666"))
  (def hospital (alura.logic/arrives-at hospital :wait "777"))
  (def hospital (alura.logic/arrives-at hospital :wait "888"))
  (pprint hospital)

  (def hospital (alura.logic/arrives-at hospital :wait "999"))
  (pprint hospital))

;(simulate-a-day)

(defn arrives-at-evil [people]
  (def hospital (alura.logic/paused-arrives-at hospital :wait "111"))
  (println "pos insert" people))

(defn simulate-parallel-day []
  (def hospital (alura.model/new-hospital))
  (.start (Thread. (fn [] (arrives-at-evil "111"))))
  (.start (Thread. (fn [] (arrives-at-evil "222"))))
  (.start (Thread. (fn [] (arrives-at-evil "333"))))
  (.start (Thread. (fn [] (arrives-at-evil "444"))))
  (.start (Thread. (fn [] (arrives-at-evil "555"))))
  (.start (Thread. (fn [] (arrives-at-evil "666"))))
  (.start (Thread. (fn [] (Thread/sleep 4000)
                          (pprint hospital)))))

(simulate-parallel-day)