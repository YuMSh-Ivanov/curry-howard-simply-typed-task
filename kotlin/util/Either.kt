package util

sealed class Either<out A, out B> {
    private class Left<A>(val value: A) : Either<A, Nothing>() {
        override val left: A
            get() = value
        override val right: Nothing
            get() = throw RuntimeException("Trying to get right when left value is stored")
        override val isLeft: Boolean
            get() = true
    }

    private class Right<B>(val value: B) : Either<Nothing, B>() {
        override val left: Nothing
            get() = throw RuntimeException("Trying to get left when right value is stored")
        override val right: B
            get() = value
        override val isLeft: Boolean
            get() = false
    }

    abstract val left: A
    abstract val right: B
    abstract val isLeft: Boolean

    companion object {
        fun <A, B> ofLeft(value: A): Either<A, B> {
            return Left(value)
        }

        fun <A, B> ofRight(value: B): Either<A, B> {
            return Right(value)
        }
    }
}