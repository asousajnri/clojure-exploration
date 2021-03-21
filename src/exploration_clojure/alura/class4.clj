(ns exploration_clojure.alura.class4)

(def prices [30 700 1000])

(println (prices 0))
(println (get prices 0))
(println (get prices 2))
;(println (prices 17))
;(println "return nil" (get prices 17))
(println "return 0 like default value" (get prices 17 0))
(println "return 0 like default value, but existed" (get prices 2 0))

(println "Add at the end of the Vector" (conj prices 2))
(println prices)

;(println (conj 5 prices))

(println (update prices 0 inc))
(println (update prices 0 dec))
(println prices)

(defn sum-1 [value]
  (println "I'm adding 1")
  (+ value 1))

(println (update prices 0 sum-1))

(defn sum-3 [value]
  (println "I'm adding 1")
  (+ value 3))

(println (update prices 0 sum-3))

(defn apply-discount? [gross-amount]
  (> gross-amount 100))

(defn discount-value [gross-amount]
      (if (apply-discount? gross-amount)
        (let [discount-rate (/ 10 100)
              discount (* gross-amount discount-rate)]
          (- gross-amount discount))
        gross-amount))

(println "map" (map discount-value prices))

(println (range 10))
(println (filter even? (range 10)))

(println "vector" prices)
(println "filter" (filter apply-discount? prices))

(println "map after filter" (map discount-value (filter apply-discount? prices)))

(println "reduce" (reduce + prices))

(defn my-sum [value-1 value-2]
      (println "somando" value-1 value-2)
      (+ value-1 value-2))

(println "reduce with my-sum" (reduce my-sum prices))
(println "reduce with my-sum" (reduce my-sum (range 10)))
(println "reduce with one value" (reduce my-sum [15]))
(println "reduce with initial value" (reduce my-sum 0 (range 10)))
(println "reduce without value" (reduce my-sum 0 []))
;(println "reduce without value" (reduce my-sum []))

