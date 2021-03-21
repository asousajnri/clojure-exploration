(ns exploration_clojure.alura.class5)

(def stock {"Backpack" 10, "T-shirt" 5})
(println stock)

(println "we have" (count stock) "elements")
(println "keys:" (keys stock))
(println "values:" (vals stock))

; keyword
; :backpack

(def stock {:backpack 10
            :t-shirt 5})

(println (assoc stock :chair 3))
(println (assoc stock :backpack 1))

(println stock)
(println (update stock :backpack inc))

(defn take-one [value]
  (println "taking out of")
  (- value 1))

(println stock)
(println (update stock :backpack take-one))

(println (update stock :backpack #(- % 3)))

(println (dissoc stock :backpack))

(def order {:backpack {:quantity 2, :price 80}
            :t-shirt {:quantity 3, :price 40}})

(def order (assoc order :locksmith {:quantity 1, :price 10}))
(println order)

(println (order :backpack))

(println (get order :backpack))
(println (get order :backpack))
(println (get order :chair {}))

(println (:backpack order))
(println (:chair order))
(println (:chair order {}))

(println (:quantity (:backpack order)))

(println (update-in order [:backpack :quantity] inc))

(println (:quantity (:backpack order)))

; THREADING

(println (-> order
    :backpack
    :quantity))

(-> order
    :backpack
    :quantity
    println)

