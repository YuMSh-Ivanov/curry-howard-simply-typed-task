#include <functional>
#include <iostream>
#include <tuple>
#include <utility>
#include <variant>

struct nothing
{
    nothing() = delete;
    nothing(const nothing&) = delete;
    nothing(nothing&&) = delete;
    nothing& operator=(const nothing&) & = delete;
    nothing& operator=(nothing&&) & = delete;
};

template <class A, class B, class C>
struct curry_howard
{
    std::function<std::function<A(B)>(A)> c1 = ???;

    std::function<std::variant<A, B>(std::pair<A, B>)> c2 = ???;

    std::function<std::variant<std::pair<A, B>, std::pair<A, C>>(std::pair<A, std::variant<B, C>>)> c3 = ???;

    std::function<C(std::pair<std::pair<std::function<C(A)>, std::function<C(B)>>, std::variant<A, B>>)> c4 = ???;

    std::function<std::pair<std::function<A(B)>, std::function<A(C)>>(std::function<A(std::variant<B, C>)>)> c5 = ???;

    nothing c6 = ???;
};

int main()
{
    curry_howard<int, int, int> c1;
    curry_howard<int,
                 std::tuple<int, int, int>,
                 std::tuple<std::tuple<int, int, int>, std::tuple<int, int, int>, std::tuple<int, int, int>>>
            c2;
}