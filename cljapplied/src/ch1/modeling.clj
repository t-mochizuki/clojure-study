(def earth {:name "Earth"
            :moons 1
            :volume 1.08321e12
            :mass 5.97219e24
            :aphelion 152098232
            :perihelion 147098290
            :type :Planet
            })

;; user> earth

(defrecord Planet [name
                   moons
                   volume
                   mass
                   aphelion
                   perihelion
                   ])

;; Type
;; user> :Planet

;; Positional factory function
;; user> (->Planet "Earth" 1 1.08321E12 5.97219E24 152098232 147098290)

;; Map factory function
;; user> (map->Planet {:name "Earth"
;;                     :moons 1
;;                     :volume 1.08321E12
;;                     :mass 5.97219E24
;;                     :aphelion 152098232
;;                     :perihelion 147098290})

;; user> (get (->Planet "Earth" 1 1.08321E1 5.97219E24 152098232 147098290) :name)
;; user> (:name (->Planet "Earth" 1 1.08321E1 5.97219E24 152098232 147098290))
