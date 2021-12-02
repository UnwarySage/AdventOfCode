(ns day2
(:require [util]))


(def raw-input (util/load-and-split-lines "res/day2.txt"))

(def parsed-input (map (fn [[command distance]]
                         [(keyword command)
                         (Integer/parseInt distance)])
                          raw-input))

(defn update-position [[x y aim] [command distance]]
  (cond 
    (= command :up) [x y (- aim distance)]
    (= command :down) [x y (+ aim distance)]
    (= command :forward) [(+ x distance)
                          (+ y (* aim distance))
                          aim]))

(defn offsets [inp-seq]
  {:up (reduce +  (map second (filter #(= :up (first %)) inp-seq)))
  :down (reduce +  (map second (filter #(= :down (first %)) inp-seq)))
  :forward (reduce +  (map second (filter #(= :forward (first %)) inp-seq)))})

(defn final-pos-from-offsets [{:keys [up down]}]
 [ (- down up)])

(comment
  raw-input
  parsed-input
  (update-position [0 0] [:down 3])
  (update-position [0 0] [:up 2])
  (update-position [0 0] [:forward 9])
  (filter #(= :up (first %)) raw-input)
  (offsets [[:down 1]])
  (offsets parsed-input)
  
  (reduce update-position [0 0 0] parsed-input)
  (* 1996 10)
  (final-pos-from-offsets {:up 1032, :down 2054, :forward 1996})
  )