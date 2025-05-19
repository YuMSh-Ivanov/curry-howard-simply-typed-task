import util.Either

class CurryHoward<A, B, C> {
    val c1: (A) -> (B) -> A = ???
    val c2: (Pair<A, B>) -> Either<A, B> = ???
    val c3: (Pair<A, Either<B, C>>) -> Either<Pair<A, B>, Pair<A, C>> = ???
    val c4: (Pair<Pair<(A) -> C, (B) -> C>, Either<A, B>>) -> C = ???
    val c5: ((Either<B, C>) -> A) -> Pair<(B) -> A, (C) -> A> = ???
    val c6: Nothing = ???
}
