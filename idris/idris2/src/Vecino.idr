
data Color:     Type where
        Rojo    : Color
        Verde   : Color
        Azul    : Color

data Vecino: (n : Int) -> (a : Type)    -> Type where
    Pepe : (x : a)                      -> Vecino 4 a       -- Está obligado a vivir eternamente en la 4 planta. Lo que dice define el tipo de pensamiento.
    Paco : (x : a)                      -> Vecino n a       -- Puede cambiar de planta en modo silencioso. Lo que dice define el tipo de pensamiento.
    Juan : (m : Int)                    -> Vecino m a       -- Siempre dice la verdad y sólo puede decir en que planta está. Jamás dirá sobre qué está pensando.
    Miguel :                             Vecino m Color     -- Es mudo y ninja. Puede cambiarse de planta de manera silenciosa. Sólo puede pensar en colores.


vecino1 : Vecino 4 Color
vecino1 = Pepe Rojo

vecino2 : Vecino 4 Color
vecino2 = Paco Azul

vecino3 : Vecino 5 Color
-- vecino3 = Pepe Rojo
vecino3 = Paco Verde

vecino4 : Vecino 5 String
vecino4 = Paco "welcome"

vecino5 : Vecino 4 Int
-- vecino5 = Pepe Rojo
vecino5 = Pepe 10

vecino6 : Vecino 5 Color
vecino6 = Miguel

vecino7 : Vecino 1000 Color
vecino7 = Miguel

vecino8 : Vecino 10 String
vecino8 = Juan 10

vecino9 : Vecino 22 String
-- vecino9 = Juan 10
vecino9 = Juan 22