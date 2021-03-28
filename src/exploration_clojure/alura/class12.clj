(ns exploration_clojure.alura.class12
  (:require [exploration_clojure.alura.db :as alura.db]
            [exploration_clojure.alura.logic :as alura.logic]))

(defn spent-a-lot? [user-info]
  (> (:total-price user-info) 500))

(let [orders (alura.db/all-orders)
      summary (alura.logic/summary-by-user orders)]
  (println "keep" (keep spent-a-lot? summary))
  (println "filter" (filter spent-a-lot? summary)))

(defn spent-a-lot? [user-info]
  (println "spent-a-lot" (:user-id user-info))
  (> (:total-price user-info) 500))

(let [orders (alura.db/all-orders)
      summary (alura.logic/summary-by-user orders)]
  (println "keep" (keep spent-a-lot? summary)))

(println (range 100))
(println (take 2 (range 10000000)))

; is not being eager, is being lazy
(let [range-sequence (range 10000000)]
  (println (take 2 range-sequence))
  (println (take 2 range-sequence)))

(defn filter1 [x]
  (println "filtro1" x)
  x)

(println (map filter1 (range 10)))

(defn filter2 [x]
  (println "filtro2" x)
  x)

(println (map filter2 (map filter1 (range 10))))

(->> (range 10)
     (map filter1)
     (map filter2)
     println)

; CHUNKS de 32
(->> (range 50)
     (map filter1)
     (map filter2)
     println)

(->> (range 50)
     (mapv filter1)
     (mapv filter2)
     println)

(->> [1 2 3 4 5 566 3 1]
     (map filter1)
     (map filter2)
     println)

; Linked list is 100% lazy
(->> '(1 2 3 4 5 6 7 8)
     (map filter1)
     (map filter2)
     println)