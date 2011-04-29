(ns eliza_clj.core
  (:use eliza_clj.utils))

(def *dict* {#"\d" "You mentioned a digit",
	     #"(?i:^hi)" "Hello!"})

(defn respond-using-kv [kv str]
  "if the regexp k matches, return v"
  (if (re-find (first kv) str)
    (second kv)))

(defn respond-using-dict [str response-dict]
  (first-true
   #(respond-using-kv % str) response-dict))