module CurryHoward (c1, c2, c3, c4, c5, c6) where
import Data.Void

c1 :: a -> b -> a
c1 ???

c2 :: (a, b) -> Either a b
c2 ???

c3 :: (a, Either b c) -> Either (a, b) (a, c)
c3 ???

c4 :: ((a -> c, b -> c), Either a b) -> c
c4 ???

c5 :: (Either b c -> a) -> (b -> a, c -> a)
c5 ???

c6 :: Void
c6 = ???
