(defn extended-euclidean
  "Returns x and y; the greatest common denominator of A and B are x * A + y * B."
  ([a b] (extended-euclidean a b 1 0 0 1))
  ([a b x y u v]
   (if (= b 0)
     [x y]
     (let [q (quot a b)
           r (mod a b)
           u' (- x (* q u))
           v' (- y (* q v))]
       (extended-euclidean b r u v u' v')))))

;; (extended-euclidean 240 66) ;; => [-3 11]
;; (+ (* 240 -3) (* 66 11)) ;; => 6
;; (extended-euclidean 520 221) ;; => [3 -7]
;; (+ (* 520 3) (* 221 -7)) ;; => 13
