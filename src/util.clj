(ns util
(:require [clojure.string :as str]))

(defn load-and-split-lines [file-path]
(map (comp #(str/split % #" ")
           str/trim)
     (str/split-lines (slurp file-path))))

(comment
(load-and-split-lines "res/day1.txt")

( #(str/split % " ")
 "1223 344  ") )