(ns advent-of-code-2020.day2-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2020.day2 :refer :all]))


(deftest finding-valid-passwords
  (testing "passwords are valid when a char appears the min number of times"
    (let [password "abc"
          mandatory-char \a
          min-occourances 1
          max-occourances 3]

      (is (true? (is-valid-password? min-occourances max-occourances mandatory-char password)))

      ))
  (testing "passwords are valid when a char appears between the min and max number of times"
    (let [password "aba"
          mandatory-char \a
          min-occourances 1
          max-occourances 3]

      (is (true? (is-valid-password? min-occourances max-occourances mandatory-char password)))

      ))
  (testing "passwords are valid when a char appears between a min and a max number of times"
    (let [password "aaa"
          mandatory-char \a
          min-occourances 1
          max-occourances 3]

      (is (true? (is-valid-password? min-occourances max-occourances mandatory-char password)))

      ))

  (testing "passwords are invalid when target char appears less than min required times"
    (let [password "ccc"
          mandatory-char \a
          min-occourances 1
          max-occourances 3]

      (is (false? (is-valid-password? min-occourances max-occourances mandatory-char password)))

      ))

  (testing "passwords are invalid when target char appears more than max required times"
    (let [password "cccc"
          mandatory-char \c
          min-occourances 1
          max-occourances 3]

      (is (false? (is-valid-password? min-occourances max-occourances mandatory-char password)))

      ))
  )

  (deftest parsing-password-input
    (testing "truns a raw triple into a min max target-char and password"
      (let [raw-input "8-9 b: bbjbbbbbbvvbbx"
            expected-min 8
            expected-max 9
            target-char \b
            password "bbjbbbbbbvvbbx"]

            (is
              (=
                [expected-min expected-max target-char password]
                (parse-password-tripple raw-input)))

            )
    ))

    (deftest counts-valid-passwords
      (testing "counts-the-number-of-valid-passwords"
        (let [raw-input "2-4 l: llrll\n3-7 j: kclqzgc\n2-3 x: rxrrrxrrrrr\n"
              expected-count 2]
              (is (= expected-count
                  (count-valid-passwords raw-input))))))
