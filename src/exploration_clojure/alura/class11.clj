(ns exploration_clojure.alura.class11
  (:use clojure.pprint)
  (:require [exploration_clojure.alura.db :as alura.db]
            [exploration_clojure.alura.logic :as alura.logic]))

(pprint (alura.db/all-orders))

(pprint (alura.logic/summary-by-user (alura.db/all-orders)))

(let [orders (alura.db/all-orders)
      summary (alura.logic/summary-by-user (alura.db/all-orders))]
  (println "Summary" summary)
  (println "Sort" (sort-by :total-price summary))
  (println "Reverse" (reverse (sort-by :total-price summary)))
  (println "Sort By :ID" (sort-by :user-id summary))

  (println "get-in" (get-in orders [0 :items :backpack :quantity])))

(defn summary-by-sort-by-user [orders]
 (->> orders
      alura.logic/summary-by-user
      (sort-by :total-price)
      reverse))

(let [orders (alura.db/all-orders)
      summary (summary-by-sort-by-user orders)]
  (pprint summary)
  (pprint (first summary))
  (pprint (second summary))
  (pprint (rest summary))
  (pprint (count summary))
  (pprint (class summary))
  (pprint (nth summary 1))
  (pprint (get summary 1))
  (pprint (take 2 summary)))

(defn top-two [orders]
  (take 2 orders))

(let [orders (alura.db/all-orders)
      summary (summary-by-sort-by-user orders)]
  (pprint summary)
  (pprint (first summary))
  (pprint (second summary))
  (pprint (rest summary))
  (pprint (count summary))
  (pprint (class summary))
  (pprint (nth summary 1))
  (pprint (get summary 1))
  (pprint (take 2 summary))
  (pprint (top-two summary)))

(let [orders (alura.db/all-orders)
      summary (summary-by-sort-by-user orders)]
  (pprint (filter #(> (:total-price %) 500) summary))
  (pprint (not  (empty? (filter #(> (:total-price %) 500) summary))))
  (pprint (some #(> (:total-price %) 500) summary)))
