data Word : Nat             -> Type where
        W : (s:String)      -> Word (String.length(s))

isPalindrom: (Word _) -> Bool 
isPalindrom (W s) = Types.reverse(s) == s

-- { w € Word | w == reverse w } // predicado: p(x) := x == reverse x
data PalindromWord : Bool       -> Type where
        PW : (w: Word _)          -> PalindromWord (isPalindrom w)


ValidPalindrom : Type
ValidPalindrom = PalindromWord True

palindrom : ValidPalindrom
palindrom = PW (W "alla")
-- palindrom = PW (W "alta")


palindomList : List ValidPalindrom
palindomList = [PW (W "alla"), PW (W "ama"), PW (W "oro")]

