(ns exploration_clojure.alura.class15
  (:use [clojure.pprint])
  (:require [exploration_clojure.alura.logic :as alura.logic]
            [exploration_clojure.alura.model :as alura.model]))

(defn atomao-test []
  (let [silveira-hospital (atom {:wait alura.model/empty-queue})]
    (println silveira-hospital)
    (pprint silveira-hospital)
    (pprint (deref silveira-hospital))
    (pprint @silveira-hospital)

    (pprint (assoc @silveira-hospital :lab1 alura.model/empty-queue))
    (pprint @silveira-hospital)

    (swap! silveira-hospital assoc :lab1 alura.model/empty-queue)
    (pprint @silveira-hospital)

    (swap! silveira-hospital assoc :lab2 alura.model/empty-queue)
    (pprint @silveira-hospital)

    (update @silveira-hospital :lab1 conj "111")

    (swap! silveira-hospital update :lab1 conj "111")
    (pprint silveira-hospital)

    ))

(atomao-test)

(defn arrives-at-evil! [hospital people]
  (swap! hospital alura.logic/paused-arrives-at-logging :wait "111")
  (println "pos insert" people))

(defn simulate-parallel-day []
  (let [hospital (atom (alura.model/new-hospital))]
    (.start (Thread. (fn [] (arrives-at-evil! hospital "111"))))
    (.start (Thread. (fn [] (arrives-at-evil! hospital "222"))))
    (.start (Thread. (fn [] (arrives-at-evil! hospital "333"))))
    (.start (Thread. (fn [] (arrives-at-evil! hospital "444"))))
    (.start (Thread. (fn [] (arrives-at-evil! hospital "555"))))
    (.start (Thread. (fn [] (arrives-at-evil! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))
  ))

(simulate-parallel-day)

(defn arrives-at-without-evil! [hospital people]
  (swap! hospital alura.logic/arrives-at :wait people)
  (println "pos insert" people))

(defn simulate-parallel-day []
  (let [hospital (atom (alura.model/new-hospital))]
    (.start (Thread. (fn [] (arrives-at-without-evil! hospital "111"))))
    (.start (Thread. (fn [] (arrives-at-without-evil! hospital "222"))))
    (.start (Thread. (fn [] (arrives-at-without-evil! hospital "333"))))
    (.start (Thread. (fn [] (arrives-at-without-evil! hospital "444"))))
    (.start (Thread. (fn [] (arrives-at-without-evil! hospital "555"))))
    (.start (Thread. (fn [] (arrives-at-without-evil! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))
    ))

(simulate-parallel-day)