(ns exploration_clojure.alura.class9)

(defn total-bill [elements]
  (loop [total-so-far 0
         rest-elements elements]
    (if (seq rest-elements)
      (recur (inc total-so-far) (next rest-elements))
      total-so-far)))

(println (total-bill ["Daniela" "Guilherme" "Carlos" "Paulo" "Lucia" "Ana"]))