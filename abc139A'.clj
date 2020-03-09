(defn solve
  ([s t] (solve s t 0))
  ([s t acc]
   (if (nil? s)
     acc
     (if (= (first s) (first t))
       (solve (next s) (next t) (inc acc))
       (solve (next s) (next t) acc)))))

(println (solve (str (read)) (str (read))))
