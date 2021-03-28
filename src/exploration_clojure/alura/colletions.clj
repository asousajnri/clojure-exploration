(ns exploration_clojure.alura.colletions
  (:use [clojure.pprint]))

(defn vector-test []
      (let [wait [111 222]]
        (println "wait =>>" wait)
        (println (conj wait 333))
        (println (conj wait 444))
        (println (pop wait))))

(vector-test)

(defn list-test []
  (let [wait '(111 222)]
    (println "list =>>" wait)
    (println (conj wait 333))
    (println (conj wait 444))
    (println (pop wait))))

(list-test)

; POP not working in #{}
(defn conj-test []
  (let [wait #{111 222}]
    (println "conj =>>" wait)
    (println (conj wait 333))
    (println (conj wait 444))
    (println (pop wait))))

(conj-test)

(defn queue-test []
  (let [wait (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
    (println (seq wait))
    (println (seq (conj wait "333")))
    (println (seq (pop wait)))
    (println (peek wait ))
    (pprint wait)))

(queue-test)