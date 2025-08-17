// @ts-check

// 'tsc --build' to compile

// genius Either implementation from https://antman-does-software.com/stop-catching-errors-in-typescript-use-the-either-type-to-make-your-code-predictable
type Left<T> = {
  left: T;
  right?: never;
};

type Right<U> = {
  left?: never;
  right: U;
};

type Either<T, U> = NonNullable<Left<T> | Right<U>>;

function makeLeft<A, B>(a : A) : Either<A, B> {
    return {left : a};
}

function makeRight<A, B>(b : B) : Either<A, B> {
    return {right : b};
}

function isLeft<A, B>(e : Either<A, B>) : boolean {
    return 'left' in e;
}

function left<A, B>(e : Either<A, B>) : A {
    return e.left!;
}

function right<A, B>(e : Either<A, B>) : B {
    return e.right!;
}


class CurryHoward<A, B, C> {
    public c1 : (_ : A) => (_ : B) => A = ???;
    public c2 : (_ : [A, B]) => Either<A, B> = p => makeLeft(p[0]);
    public c3 : (_ : [A, Either<B, C>]) => Either<[A, B], [A, C]> = ???;
    public c4 : (_ : [[(_ : A) => C, (_ : B) => C], Either<A, B>]) => C = ???;
    public c5 : (_ : (_ : Either<B, C>) => A) => [(_ : B) => A, (_ : C) => A] = ???;
    public c6 : never = ???;
}
