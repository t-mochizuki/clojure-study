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

(defn inverse
  "Returns the inverse of a value A in modulo N."
  [a n]
  (let [[x y] (extended-euclidean a n)
        gcd (+ (* a x) (* n y))]
    (if (= gcd 1)
      (mod x n))))

;; (inverse 5 7) ;; => 3
;; (inverse 3 3016) ;; => 2011
