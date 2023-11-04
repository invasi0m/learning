
-- Zn := Z/nZ
-- Let n € N, for all a € Z => a € Zn <=>  mod a n == 0
-- Let n € N, Zn := { a € Z | mod a n == 0} // predicado: p(x) := mod x n == 0

data Congruent : (m : Int) -> Bool -> Type where
    C: (n:Int) ->  Congruent m ((mod n m) == 0)

-- type function
Z : Int -> Type
Z n = List (Congruent n True)

NoZ : Int -> Type
NoZ n = List (Congruent n False) 


Z7Set: Z 7
Z7Set = [C 0, C 7, C 14, C 21, C 28]

noZ7Set: NoZ 7
noZ7Set = [C 1, C 2, C 3, C 4]