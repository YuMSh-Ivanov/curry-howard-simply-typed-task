package util;

public final class Pair<X, Y> {
    private final X first;
    private final Y second;

    private Pair(final X first, final Y second) {
        this.first = first;
        this.second = second;
    }

    public static <X, Y> Pair<X, Y> of(X first, Y second) {
        return new Pair<>(first, second);
    }

    public Y second() {
        return second;
    }
    public X first() {
        return first;
    }
}
