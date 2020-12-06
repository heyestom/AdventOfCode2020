(ns advent-of-code-2020.core
  (:require [advent-of-code-2020.day1 :as day1]
            [advent-of-code-2020.day2 :as day2]))

(defn main [& args]
  (case (first args)
    "1" (day1/main)
    "2" (day2/main)
    nil (println "provide day number day to run...")))

