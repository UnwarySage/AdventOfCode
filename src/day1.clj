(ns day1
(:require [clojure.string :as str]))

(def numbers-raw (slurp "res/day1.txt"))

(defn number-str->seq [numbers]
  (map (fn [x]
  (Integer/parseInt x)) (str/split-lines numbers)))

(defn succesive-differences "takes a seq of numbers, and returns the seq n1 - n2"
[inp-seq]
(map - (rest inp-seq) inp-seq))


(defn sliding-sum "slides through an input sequence, summing every three numbers"
[inp-seq window]
(map (partial apply +) (partition window 1 inp-seq)))

(defn count-positives "counts the number of positive entries in a sequence"
  [inp-seq]
  (count (filter pos? inp-seq)))

(defn count-increases "takes a number seq, and returns the number of succesive increases"
[inp-seq]
(count (filter pos? (succesive-differences inp-seq))))


(defn count-windowed-increases 
[inp-seq window]
(-> inp-seq 
(sliding-sum window)
(succesive-differences)
(count-positives)))

(comment 
  (Integer/parseInt "3")
  (succesive-differences [5 5 5 7])
  (count-increases [5 5 5 5 7 8 7])
  (count-increases (number-str->seq numbers-raw))
  (partition 3 1 (range 10) )
  (def inp-seq (number-str->seq numbers-raw))
  (sliding-sum inp-seq 3)
  (count-windowed-increases (number-str->seq numbers-raw) 3)
  )
