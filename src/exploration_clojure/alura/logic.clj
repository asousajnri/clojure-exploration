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

(defn fit-on-the-queue? [hospital department]
  (-> hospital
      (get department)
      count
      (< 5)))

(defn arrives-at [hospital department people]
    (if (fit-on-the-queue? hospital department)
        (update hospital department conj people)
        (throw (ex-info "Queue is already filled" {:try-add people}))))

(defn paused-arrives-at [hospital department people]
  (Thread/sleep (* (rand) 2000))
  (if (fit-on-the-queue? hospital department)
    (do
      ;(Thread/sleep (* (rand) 1000))
      (update hospital department conj people))
    (throw (ex-info "Queue is already filled" {:try-add people}))))

(defn paused-arrives-at-logging [hospital department people]
  (println "try add new people" people)
  (Thread/sleep (* (rand) 2000))
  (if (fit-on-the-queue? hospital department)
    (do
      ;(Thread/sleep (* (rand) 1000))
      (println "Updating..." people)
      (update hospital department conj people))
    (throw (ex-info "Queue is already filled" {:try-add people}))))

(defn meets [hospital department]
  (update hospital department pop))