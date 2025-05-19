import java.util.function.Function;
import util.Pair;
import util.Either;

public class CurryHoward<A, B, C> {
    public final Function<A, Function<B, A>> c1 = ???;
    public final Function<Pair<A, B>, Either<A, B>> c2 = ???;
    public final Function<Pair<A, Either<B, C>>, Either<Pair<A, B>, Pair<A, C>>> c3 = ???;
    public final Function<Pair<Pair<Function<A, C>, Function<B, C>>, Either<A, B>>, C> c4 = ???;
    public final Function<Function<Either<B, C>, A>, Pair<Function<B, A>, Function<C, A>>> c5 = ???;
    public final Void c6 = ???;
}
