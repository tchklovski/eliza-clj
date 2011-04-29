(ns eliza_clj.core)

(def *dict* {#"\d" "You mentioned a digit",
	     #"(?i:^hi)" "Hello!"})

(defn respond-using-kv [kv str]
  "if the regexp k matches, return v"
  (if (re-find (first kv) str)
    (second kv)))

;;; todo: have a more full-fledged "rule" and maybe
;;; rule match/evaluate structure

(def *canned-responses*
     ["that's not necessarily a bad thing", "hmmm"])

(defn respond-using-dict
  ([str] (respond-using-dict str *dict*))
  ([str response-dict]
    (some
      #(respond-using-kv % str) response-dict)))

(defn respond-random
  ([] (respond-random *canned-responses*))
  ([col] (rand-nth col)))

(defn respond [q]
  (or (respond-using-dict q)
      (respond-random)))



(defn add-to-dict
  ([key val] (add-to-dict key val *dict*))
  ([key val dict]
    (assoc! dict key val)
    [key val]))

;; evaluate efficacy of a rule -- global, and context-sensitive
