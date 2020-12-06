(ns advent-of-code-2020.day2
   (:require [clojure.string :as str]))

(defn- occourances-of-char-in-string [target-char string] (count (filter #(= target-char %) string)))

(defn is-valid-password? [min max target-char password]
  (let [char-occourances (occourances-of-char-in-string target-char password)]
    (<= min char-occourances max)))


(defn- read-data [] (slurp  "src/advent_of_code_2020/day2data.txt"))

(defn parse-password-tripple [raw-db-row]
  (let [[range target password] (str/split raw-db-row #"\s")
        [min max] (str/split range #"-")
        target-char (first target)]
  [(Integer/parseInt min) (Integer/parseInt max) target-char password]

  ))

(defn count-valid-passwords [raw-password-data]
  (->> (clojure.string/split-lines raw-password-data)
    (map parse-password-tripple)
    (filter #(apply is-valid-password? %))
    (count)))

(defn main []
  (let [password-triples  (read-data)]
  (println "count of valid: "
          (str (count-valid-passwords password-triples))
  )))
