(ns aoc-2017.day-01)

(def input (-> "inputs/day_01" slurp clojure.string/trim))

(defn str->digits
  [s]
  (let [char->digit (zipmap "0123456789" (range))]
    (map char->digit s)))

(def data (str->digits input))

(defn pair-next
  [coll]
  (->> coll
       (cons (last coll))
       (partition 2 1)))

(defn pair-halfway
  [coll]
  (let [offset (-> coll count (/ 2))]
    (->>
      (-> coll cycle (nthrest offset))
      (mapv list coll))))

(defn solve
  [make-pairs]
  (->> data
       (make-pairs)
       (filter #(apply = %))
       (map first)
       (reduce +)))

(println "Solution part 1:" (solve pair-next))
(println "Solution part 2:" (solve pair-halfway))
