(ns exploration_clojure.alura.class10
  (:use clojure.pprint)
  (:require [exploration_clojure.alura.db :as alura-db]))

(pprint (alura-db/all-orders))

(pprint (group-by :user (alura-db/all-orders)))

(defn my-group-my [element]
  (println "element" element)
  (:user element))

(pprint (group-by my-group-my (alura-db/all-orders)))

(println (count (vals (group-by :user (alura-db/all-orders)))))

(println (map count (vals (group-by :user (alura-db/all-orders)))))

(->> (alura-db/all-orders)
     (group-by :user)
     vals
     (map count)
     pprint)

(defn total-bill-by-user [[user orders]]
  (count orders))

(->> (alura-db/all-orders)
     (group-by :user)
     (map total-bill-by-user)
     pprint)

(defn total-bill-by-user [[user orders]]
  [user (count orders)])

(->> (alura-db/all-orders)
     (group-by :user)
     (map total-bill-by-user)
     pprint)

(defn total-bill-by-user [[user orders]]
  {:user-id user
   :total-orders (count orders)})

(->> (alura-db/all-orders)
     (group-by :user)
     (map total-bill-by-user)
     pprint)

(defn total-item [[_ details]]
  (* (get details :quantity 0) (get details :unit-price 0)))

(defn total-order [order]
  (->> order
       (map total-item)
       (reduce +)))

(defn total-orders [orders]
  (->> orders
       (map :items)
       (map total-order)
       (reduce + )))

(defn quantity-orders-total-bill-by-user [[user orders]]
  {:user-id user
   :total-orders (count orders)
   :total-price (total-orders orders)})

(->> (alura-db/all-orders)
     (group-by :user)
     (map quantity-orders-total-bill-by-user)
     pprint)