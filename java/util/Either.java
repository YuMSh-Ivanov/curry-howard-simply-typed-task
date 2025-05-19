package util;

public sealed abstract class Either<X, Y> {
    public abstract boolean isLeft();
    public abstract X left();
    public abstract Y right();

    public static <X, Y> Either<X, Y> ofLeft(final X value) {
        return new Left<>(value);
    }
    public static <X, Y> Either<X, Y> ofRight(final Y value) {
        return new Right<>(value);
    }

    private final static class Left<X, Y> extends Either<X, Y> {
        final X value;
        public Left(final X value) {
            this.value = value;
        }
        @Override
        public boolean isLeft() {
            return true;
        }
        @Override
        public X left() {
            return value;
        }
        @Override
        public Y right() {
            throw new RuntimeException("Trying to get right when left value is stored");
        }
    }

    private final static class Right<X, Y> extends Either<X, Y> {
        final Y value;

        public Right(final Y value) {
            this.value = value;
        }
        @Override
        public boolean isLeft() {
            return false;
        }
        @Override
        public X left() {
            throw new RuntimeException("Trying to get left when right value is stored");
        }
        @Override
        public Y right() {
            return value;
        }
    }
}


