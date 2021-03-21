(ns exploration_clojure.alura.logic)

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

(defn summary-by-user [orders]
  (->> orders
       (group-by :user)
       (map quantity-orders-total-bill-by-user)))

