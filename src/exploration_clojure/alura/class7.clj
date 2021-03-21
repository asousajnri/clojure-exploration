(ns exploration_clojure.alura.class7)

; ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]
; {"Guilherm" 37, "Paulo" 39}
; '(1 2 3 4)
; [[0 1]]
; #{}

; map
; filter
; reduce

; loop
; for

(map println ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"])
(println (first ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (rest ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (rest []))
(println (next ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (next []))
(println (seq []))
(println (seq [1 2 3 4 5]))

;(defn my-map [function sequence-value]
;  (let [first-element (first sequence-value)]
;    (function first-element)
;    (my-map function (rest sequence-value))))

(defn my-map [function sequence-value]
  (let [first-element (first sequence-value)]
    (if first-element
      (do
        (function first-element)
        (my-map function (rest sequence-value))))))

(defn my-map [function sequence-value]
  (let [first-element (first sequence-value)]
    (if (not (nil? first-element))
      (do
        (function first-element)
        (my-map function (rest sequence-value))))))

;(my-map println ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"])
(my-map println ["Daniela" false "Carlos" "Paulo" "Lucia" "Ana"])
(my-map println [])
(my-map println nil)

;(my-map println (range 10000000))

(defn my-map [function sequence-value]
  (let [first-element (first sequence-value)]
    (if (not (nil? first-element))
      (do
        (function first-element)
        (recur function (rest sequence-value))))))

(my-map println (range 50000))
