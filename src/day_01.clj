(ns aoc-2017.day-01)

(def input "1122")

(defn str->digits
  [s]
  (let [char->digit (zipmap "0123456789" (range))]
    (map char->digit s)))

(def data (str->digits input))

(defn solve []
  (->> data                   ;   (1 1 2 2)
       (cons (last data))     ; (2 1 1 2 2)
       (partition 2 1)        ; ((2 1) (1 1) (1 2) (2 2))
       (filter #(apply = %))  ; ((1 1) (2 2))
       (map first)            ; (1 2)
       (reduce +)))           ; 3

