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

(def people
  {"p1" (->Person "Alex" "Miller")})

;; user> people

(def recipes
  {"r1" (->Recipe
         "Toast"
         "p1"
         "Crispy bread"
         ["Slice of bread"]
         ["Toast bread in toaster"]
         1)})

;; user> recipes
