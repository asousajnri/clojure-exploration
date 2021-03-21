(ns exploration_clojure.alura.class8)

; ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]

(defn total-bill [total-so-far elements]
  (recur (inc total-bill) (rest elements)))

;(println (total-bill 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))

(defn total-bill [total-so-far elements]
  (if (next elements)
    (recur (inc total-so-far) (next elements))))

(println (total-bill 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))

(defn total-bill [total-so-far elements]
  (println total-so-far elements)
  (if (next elements)
    (recur (inc total-so-far) (next elements))
    (inc total-so-far)))

(println (total-bill 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (total-bill 0 []))

(defn total-bill [total-so-far elements]
  (println total-so-far elements)
  (if (seq elements)
    (recur (inc total-so-far) (next elements))
    total-so-far))

(println (total-bill 0 ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))
(println (total-bill 0 []))

(defn my-function
  ([param1] (println "p1" param1))
  ([param1 param2] (println "p2" param2)))

(my-function 1)

(defn total-bill
  ([elements]
   (total-bill 0 elements))

  ([total-so-far elements]
  (if (seq elements)
    (recur (inc total-so-far) (next elements))
    total-so-far)))

(total-bill ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"])