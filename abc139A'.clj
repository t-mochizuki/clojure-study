(defn solve
  ([s t] (solve s t 0))
  ([s t acc]
   (if (nil? s)
     acc
     (solve (next s)
            (next t)
            (if (= (first s) (first t))
              (inc acc)
              acc)))))

(println (solve (str (read)) (str (read))))
