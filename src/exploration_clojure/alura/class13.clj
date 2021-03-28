(ns exploration_clojure.alura.class13
  (:use [clojure.pprint])
  (:require [exploration_clojure.alura.model :as alura.model]))

(let [my-hospital (alura.model/new-hospital)]
  (pprint my-hospital))

(pprint alura.model/empty-queue)