import Data.Vect

v1 : Vect 5 Int
v1 = [1, 2, 3, 4, 5]
-- v1 = [1, 2, 3, 4]


takeVectZ:   (n: Nat) -> Vect (n + m) a      -> Vect n a
takeVectZ    Z xs                            = []
takeVectZ    (S k) (x :: xs)                 = x :: (takeVectZ k xs)
