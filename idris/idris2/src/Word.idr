data Word : Nat             -> Type where
        W : (s:String)      -> Word (String.length(s))

w1 : Word 0
w1 = W ""

w2 : Word 4
w2 = W "hola"

ValidWord : Type
ValidWord = Word 4

valid: ValidWord
valid = W "hola"

valid2: ValidWord
valid2 = W "casa"

-- invalid: ValidWord
invalid: Word 5
invalid = W "mundo"


validWords: List ValidWord
validWords = [W "hola", W "casa", W "aaaa"]
