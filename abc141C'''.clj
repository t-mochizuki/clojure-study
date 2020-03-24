(defn readline [s]
  (map #(Long/parseLong %)
       (clojure.string/split s #"\s")))

(defn readlines []
  (map #(Long/parseLong %)
       (line-seq (clojure.java.io/reader *in*))))

(defn p [^java.io.PrintWriter f ^java.lang.Long x]
  (.println f (if (> x 0) "Yes" "No")))

(defn solve [as f n k i v]
  (if (empty? as)
    (if (= n i)
      (p f (+ k v))
      (do
        (p f (+ k v))
        (recur as f n k (inc i) 0)))
    (if (= (first as) i)
      (recur (next as) f n k i (inc v))
      (do
        (p f (+ k v))
        (recur as f n k (inc i) 0)))))

(let [[n k q] (readline (read-line))
      as (sort (readlines))
      k' (- k q)
      fout (java.io.PrintWriter. (clojure.java.io/writer *out*))]
  (do
    (solve as fout n k' 1 0)
    (.flush fout)))
