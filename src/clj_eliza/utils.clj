(ns clj_eliza.utils)

(defn first-true [fn col]
  "return the first true value of applying fn to col"
  (first (filter identity (map fn col))))


