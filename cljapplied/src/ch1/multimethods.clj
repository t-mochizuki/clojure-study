(ns ch1.multimethod
  (:require [schema.core :as s]))

(defrecord Currency [divisor sym desc])

(declare validate-same-currency)

(defn- validate-same-currency
  [m1 m2]
  (or (= (:currency m1) (:currency m2))
      (throw
       (ex-info "Currencies do not match."
                {:m1 m1 :m2 m2}))))

(defrecord Money [amount ^Currency currency]
  java.lang.Comparable
  (compareTo [m1 m2]
    (validate-same-currency m1 m2)
    (compare (:amount m1) (:amount m2))))

(def zero-dollars (->Money 0 :usd))

(s/defrecord Ingredient
    [name :- s/Str
     quntity :- s/Int
     unit :- s/Keyword
     money :- Money
     ])

(def apple
  (->Ingredient "Apple" 1 :lb (->Money 1 :usd)))

(def orange
  (->Ingredient "Orange" 5 :lb (->Money 2 :usd)))

(defrecord Store [entities :- [Ingredient]])

(def fruit-store
  (->Store [apple orange]))

(cost apple fruit-store)

(cost orange fruit-store)

(s/defrecord Recipe
    [name :- s/Str
     description :- s/Str
     ingredients :- [Ingredient]
     steps :- [s/Str]
     servings :- s/Int
     ])

(def fruit-cake
  (->Recipe "Fruit Cake"
            "Apple and orange make a cake"
            [apple orange]
            3
            1))

(cost fruit-cake fruit-store)

(defn cost-of [store ingredient]
  (:money ingredient))

(defn +$
  ([m1] m1)
  ([m1 m2]
   (validate-same-currency m1 m2)
   (->Money (+ (:amount m1) (:amount m2)) (:currency m1)))
  ([m1 m2 & monies]
   (reduce +$ m1 (conj monies m2))))

(defmulti cost (fn [entity store] (class entity)))

(defmethod cost Ingredient [ingredient store]
  (cost-of store ingredient))

(defmethod cost Recipe [recipe store]
  (reduce +$ zero-dollars
          (map #(cost % store) (:ingredients recipe))))
