(defrecord Recipe
    [name
     author
     description
     ingredients
     steps
     servings
     ])

(defrecord Person
    [fname
     lname
     ])

;; user> (->Person "Alex" "Miller")

(def toast
  (->Recipe
   "Toast"
   (->Person "Alex" "Miller") ;; nested
   "Crispy bread"
   ["Slice of bread"]
   ["Toast bread in toaster"]
   1))

;; user> toast
