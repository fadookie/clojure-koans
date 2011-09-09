(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :fade-out          :you-and-what-army
        :double-take       :call-me-when-its-important
        :round-house       :o-rly
        :fast-pace         :thats-pretty-bad
        :cocked-pistol     :sirens
        :say-what?))

(meditations
  "You will face many decisions"
  (= :a (if (false? (= 4 5))
            :a
            :b))

  "false? is a shortcut for (= false" ;) -Eliot
  (= (false? false) (= false false))

  "Some of them leave you no alternative"
  (= [] (if (> 4 3)
            []))

  "And in such a situation you may have nothing"
  (= nil (if (nil? 0)
             [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
                :doom
                :glory))
  ;Hey, (not x) is just like our old C friend !(x) :)

  "You may have a multitude of possible paths"
  (let [x 5]
    (= :your_road (cond (= x 6) :road_not_taken
                        (= x 7) :another_road_not_taken
                        :else :your_road)))

;Check out the differences inside of a let due to '() style list specification (delayed evaluation...?)
;(let    [x 1
;        y 2]
;'(x y))
;evals to (x y)

;(let    [x 1
;        y 2]
;(list x y))
;evals to (1 2)

;((let    [x 1
;        y 2]
;#(list x y)))
;evals to (1 2)

  "Or your fate may be sealed"
  (= 'doom (if-not (zero? 0)
                'doom
                'doom))

  "Or not" ;) -Eliot
  (= 'boom (if-not (zero? 0)
                'doom
                'boom))

  "In case of emergency, sound the alarms"
  (= :sirens
     (explain-defcon-level :cocked-pistol))

  "But admit it when you don't know what to do"
  (= :say-what?
     (explain-defcon-level :yo-mama)))

