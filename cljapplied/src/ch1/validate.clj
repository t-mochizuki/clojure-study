(defrecord Recipe
    [name
     description
     ingredients
     steps
     servings
     ])

(defrecord Ingredient
    [name
     quntity
     unit
     ])

(def spagetti-tacos
  (map->Recipe
   {:naem "Spagetti tacos"
    :description "It's spagetti... in a tacos"
    :ingredients [(->Ingredient "Spagetti" 1 :lb)
                  (->Ingredient "Spagetti sauce" 16 :oz)
                  (->Ingredient "Taco shell" 12 :shell)]
    :steps ["Cook spagetti according to box."
            "Heat spagetti sauce until warm."
            "Mix spagetti ans sauce."
            "Put spagetti in taco shells and serve."]
    :servings 4}))

;; user> spagetti-tacos
