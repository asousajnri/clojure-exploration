(ns exploration_clojure.alura.class6)

(def order {:backpack {:quantity 2, :price 80}
            :t-shirt {:quantity 3, :price 40}})

(defn print-and-15 [value]
      (println "value" value)
      15)

(defn print-and-15 [value]
  (println "value" (class value) value)
  15)

(defn print-and-15 [key value]
  (println key "and" value)
  15)

(defn print-and-15 [[key value]]
  (println key "<and>" value)
  15)

(defn print-and-15 [[key value]]
  value)

(println (map print-and-15 order))

(defn products-price [[key value]]
  (* (:quantity value) (:price value)))

(println (map products-price order))
(println (reduce + (map products-price order)))

(defn products-price [[_ value]]
  (* (:quantity value) (:price value)))

(println (map products-price order))
(println (reduce + (map products-price order)))

(defn total-order [order]
  (reduce + (map products-price order)))

(println (total-order order))

(defn total-order [order]
  (->> order
      (map products-price)
      (reduce +)))

(defn product-price [product]
  (* (:quantity product) (:price product)))

(defn total-order [order]
  (->> order
       vals
       (map product-price)
       (reduce +)))

(println (total-order order))

(def order {:backpack {:quantity 2, :price 80}
            :t-shirt {:quantity 3, :price 40}
            :locksmith {:quantity 1}})

(defn is-free? [item]
  (<= (get item :price 0) 0))

(defn is-free? [item]
  (println item)
  (<= (get item :price 0) 0))

(defn is-free? [item]
  (<= (get item :price 0) 0))

(filter is-free? (vals order))

(defn is-free? [[_ item]]
  (<= (get item :price 0) 0))

(filter is-free? order)

(defn is-free? [item]
  (<= (get item :price 0) 0))

(println (filter  (fn [[_ item]] (is-free? item)) order))

(println (filter #(is-free? (second %)) order))

(defn is-pay? [item]
  (not (is-free? item)))

(println (is-pay? {:price 50}))
(println (is-pay? {:price 0}))

(println ((comp not is-free?) {:price 50}))
(println ((comp not is-free?) {:price 0}))

(def is-pay? (comp not is-free?))
(println (is-pay? {:price 50}))
(println (is-pay? {:price 0}))