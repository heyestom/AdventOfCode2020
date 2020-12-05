(ns advent-of-code-2020.core
  (:require [advent-of-code-2020.day1 :as day1]))

(defn main [& args]
  (case (first args)
    "1" (day1/main)
    nil (println "provide day number day to run...")))

