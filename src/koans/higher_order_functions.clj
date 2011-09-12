(meditations

  "The map function relates a sequence to another"
  (= [4 8 12] (map (fn [x] (* 4 x)) [1 2 3]))

  "You may create that mapping"
  (= [1 4 9 16 25] (map (fn [x] (* x x)) [1 2 3 4 5]))

  "Or use the names of existing functions"
  (= '(false false true false false) (map nil? [:a :b nil :c :d]))

  "A filter can be strong"
  (= '() (filter (fn [x] false) '(:anything :goes :here)))

  "Or very weak"
  (= '(:anything :goes :here) (filter (fn [x] true) '(:anything :goes :here)))

  "Or somewhere in between"
  (= [10 20 30] (filter (fn [x] (if (< x 40) x)) [10 20 30 40 50 60 70 80]))

  "Unpacking that one from above.." ;) -Eliot
  (= 30 ((fn [x] (if (< x 40) x)) 30))

  "It works!" ; -Eliot
  (= nil ((fn [x] (if (< x 40) x)) 40))

  "Maps and filters may be combined"
  (= [10 20 30] (map (fn [x] (* x 10)) (filter (fn [x] (if (< x 4) x)) [1 2 3 4 5 6 7 8])))

  "Reducing can increase the result"
  (= 24 (reduce (fn [a b] (* a b)) [1 2 3 4]))

  "Nested list reduce" ; -Eliot
  (= '((4) ((3) ((2) 1))) (reduce (fn [a b] (conj (list a) (list b))) [1 2 3 4]))

  "Ghetto java-style type check"
  (= (type #{1}) clojure.lang.PersistentHashSet)

  "Idiomatic clojure type check :)"
  (set? #{1})

  "I accidentally just re-implemented set, oops." ; -Eliot
  (= #{1 2 3 4} (reduce (fn [a b] (cond
                      (and (set? a) (set? b)) (clojure.set/union #{a} #{b})
                      (and (set? a) (not (set? b))) (conj a b)
                      (and (not (set? a)) (set? b)) (conj b a)
                      (and (not (set? a)) (not (set? b))) (conj #{a} b)
                    )) ;This function would make a great higher-order function/macro, eh?
          [1 1 2 2 2 3 3 3 4 3 3 1])
  )

  "Push onto a list with a reduce operation" ; -Eliot
  (= [1 2 3 4] (reverse (reduce (fn [a b] (if
                                    (list? a) (conj a b)
                                    (list b a)
                                 ))
                       [1 2 3 4])))

  "You can start somewhere else"
  (= 2400 (reduce (fn [a b] (* a b)) __ [1 2 3 4]))

  "Numbers are not the only things one can reduce"
  (= "longest" (reduce (fn [a b]
                         (if (< __ __) b a))
                       ["which" "word" "is" "longest"])))
