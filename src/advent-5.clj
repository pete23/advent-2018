(ns advent-5
  (:require [clojure.test :refer :all]))

(defn read-input [filename]
  (-> filename
      clojure.java.io/resource
      slurp))

(def input (read-input "day-5.input"))
(def test-input "dabAcCaCBAcCcaDA")

(defn atol [a] (Long/parseLong a))

(defn different-case-same-letter [left right]
  (and (= (Character/toLowerCase left) (Character/toLowerCase right))
       (not (= (Character/isLowerCase left) (Character/isLowerCase right)))))

(defn react [sb]
  (let [l (.length sb)]
    (if (and (> l 1) (different-case-same-letter
    (vec (drop-last 2 stack))
    str))

(defn process [input]
  (reduce #(react (.append %1 %2)) (StringBuilder.) input))

(deftest part-one-test
  (is (= "dabCBAcaDA" (apply str (process "dabAcCaCBAcCcaDA")))))

(defn part-one []
  (count (process input)))
