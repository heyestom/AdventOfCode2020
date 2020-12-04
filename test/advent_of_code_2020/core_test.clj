(ns advent-of-code-2020.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2020.core :refer :all]))

(deftest finding-two-nums-with-summate-to-target
  (testing "when two numbers in a list sumate to the target val returns them in a tuple"
    (let [input [2 3 8]
          target 10]
      (is (= [2 8] (find-tupple-suming target input)))))

  (testing "when no numbers in the input sum to the target val returns nil"
    (let [input [2 3 1]
          target 1000]
      (is (nil? (find-tupple-suming target input)))))
  )

(deftest finding-three-nums-with-summate-to-target
  (testing "when two numbers in a list sumate to the target val returns them in a tuple"
    (let [input [2 3 8 10]
          target 20]
      (is (= (sort [10 2 8]) (sort (find-tripple-suming target input))))))

  (testing "when no numbers in the input sum to the target val returns nil"
    (let [input [2 3 1 4]
          target 1000]
      (is (nil? (find-tripple-suming target input)))))
  )



