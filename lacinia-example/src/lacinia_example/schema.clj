(ns lacinia-example.schema
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [com.walmartlabs.lacinia.schema :as schema]
    [com.walmartlabs.lacinia.util :as util]))

(defn picture [size]
  {:width size :height size})

(defn resolver-map
  []
  (let [data (-> (io/resource "data.edn")
                 slurp
                 edn/read-string)
        products-map (->> data
                          :products)]
    (do
      {:query/numbers (fn [context args value]
                        [2 3 4])
       :query/products (fn [context args value]
                         products-map)
       :query/picture (fn [context args value]
                        (picture (:size args)))})))

(defn load-schema
  []
  (-> (io/resource "schema.edn")
      slurp
      edn/read-string
      (util/attach-resolvers (resolver-map))
      schema/compile))
