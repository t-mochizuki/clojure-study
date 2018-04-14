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
