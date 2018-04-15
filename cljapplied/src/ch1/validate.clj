(ns ch1.validate
  (:require [schema.core :as s]))

(s/defrecord Ingredient
    [name :- s/Str
     quntity :- s/Int
     unit :- s/Keyword
     ])

(s/defrecord Recipe
    [name :- s/Str
     description :- s/Str
     ingredients :- [Ingredient]
     steps :- [s/Str]
     servings :- s/Int
     ])

(def spagetti-tacos
  (map->Recipe
   {:name "Spagetti tacos"
    :description "It's spagetti... in a tacos"
    :ingredients [(->Ingredient "Spagetti" 1 :lb)
                  (->Ingredient "Spagetti sauce" 16 :oz)
                  (->Ingredient "Taco shell" 12 :shell)]
    :steps ["Cook spagetti according to box."
            "Heat spagetti sauce until warm."
            "Mix spagetti ans sauce."
            "Put spagetti in taco shells and serve."]
    :servings 4}))

;; user> (require 'ch1.validate)
;; user> (in-ns 'ch1.validate)
;; ch1.validate> spagetti-tacos

;; ch1.validate> (s/check Recipe spagetti-tacos)
;; {:name (not (instance? java.lang.String nil)), :naem disallowed-key}
;; ch1.validate> (s/check Recipe spagetti-tacos)
;; nil

;; ch1.validate> (s/defn add-ingredients :- Recipe
;;                 [recipe :- Recipe & ingredients :- [Ingredient]]
;;                 (update-in recipe [:ingredients] into ingredients))
;; #'ch1.validate/add-ingredients
;; ch1.validate> (doc add-ingredients)
