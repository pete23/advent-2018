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
  (let [lower-left (Character/toLowerCase left)
        lower-right (Character/toLowerCase right)
        left-lower (Character/isLowerCase left)
        right-lower (Character/isLowerCase right)]
    (and (= lower-left lower-right)
         (not (= left-lower right-lower)))))

(defn reactive? [[left right]]
  (and left right (different-case-same-letter left right)))

(defn react [stack]
  (if (reactive? (take-last 2 stack))
    (vec (drop-last 2 stack))
    stack))

(defn process [input]
  (reduce #(react (conj %1 %2)) [] input))

(deftest part-one-test
  (is (= "dabCBAcaDA" (apply str (process "dabAcCaCBAcCcaDA")))))

(defn part-one []
  (count (process input)))
