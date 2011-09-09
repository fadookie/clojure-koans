(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations
  "Functions are often defined before they are used"
  (= 20 (multiply-by-ten 2))

  "But they can also be defined inline"
  (= 4 ((fn [n] (* n n)) 2))

  "Or using even shorter syntax"
  (= 30 (#(* 15 %) 2))

  "Short anonymous functions may take multiple arguments"
  (= 15 (#(+ %1 %2 %3) 4 5 6))

  "One function can beget another"
  (= 9 ((fn []
            ((fn [a b] (+ a b))
              4 5))))
;can't nest #()'s - java.lang.IllegalStateException: Nested #()s are not allowed
;  (= 9 ( (fn [] (   #(+ %1 %2)
;        4 5) ) )) 
;This doesn't work either, the REPL just craps out
;    (try #( (   #(+ %1 %2)
;        4 5) )
;        (catch java.lang.IllegalStateException e "Woops"))

;This works though
;(def x)
;(try x
;(catch java.lang.IllegalStateException e "Woops"))

;This works too! Phew.
;(defn foobar [] #(+ %1 %2))
;(= 2 ((foobar) 1 1))
;(= 9 (#( (foobar) 
;        4 5 )))


  "Higher-order functions take function arguments"
  (= 25 ((fn [x f] (f x)) 5 ;Holy crap I can't believe I just wrote that and it works @_@
          (fn [n] (* n n))))

  "But they are often better written using the names of functions"
  (= 25 ((fn [x f] (f x)) 5 square))

  "This also works. ;)"
  (= 25 (#(%2 %1) 5 square)))

