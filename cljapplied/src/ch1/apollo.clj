(ns ch1.apollo)

(def mission-defaults {:orbits 0 :evas 0})

;; user> ch1.apollo/mission-defaults

(defn make-mission
  [name system launched manned? & opts]
  (let [{:keys [cm-name ;; command module
                lm-name ;; lunar module
                orbits
                evas]
         :or {orbits 0 evas 0}} opts]
    {:name name
     :system system
     :launched launched
     :manned? manned?
     :cm-name cm-name
     :lm-name lm-name
     :orbits orbits
     :evas evas}))

(def apollo-4
  (ch1.apollo/make-mission "Apollo 4"
                           "Saturn V"
                           #inst "1967-11-09T12:00:01-00:00"
                           false
                           :orbits 3))

(def apollo-11
  (ch1.apollo/make-mission "Apollo 11"
                           "Saturn "
                           #inst "1969-07-16T13:32:00-00:00"
                           true
                           :cm-name "Columbia"
                           :lm-name "Eagle"
                           :orbits 30
                           :evas 1))

(defn euclidean-norm [ecc-vector] ecc-vector)

;; user> (ch1.apollo/euclidean-norm 3)

(defrecord Planet [name
                   moons
                   volume
                   mass
                   aphelion
                   perihelion
                   orbital-eccentricity
                   ])

;; user> (->Planet "Earth" 1 1.08321E12 5.97219E24 152098232 147098290 3)

(defn make-planet
  "Make a planet from field values and an eccentricity vector"
  [name
   moons
   volume
   mass
   aphelion
   perihelion
   ecc-vector]
  (->Planet
   name moons volume mass aphelion perihelion
   (ch1.apollo/euclidean-norm ecc-vector)))

;; (ch1.apollo/make-planet "Earth"
;;                         1
;;                         1.08321e12
;;                         5.97219e24
;;                         152098232
;;                         147098290
;;                         3
;;                         )
