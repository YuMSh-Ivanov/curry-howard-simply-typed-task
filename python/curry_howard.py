# Use 'mypy curry_howard.py' to check types

from typing import Callable, TypeVar, Tuple, Never
from safe_union import SafeUnion, unionLeft, unionRight

A = TypeVar('A')
B = TypeVar('B')
C = TypeVar('C')

c1 : Callable[[A], Callable[[B], A]] = ???
c2 : Callable[[Tuple[A, B]], SafeUnion[A, B]] = lambda a: unionLeft(a[0])
c3 : Callable[[Tuple[A, SafeUnion[B, C]]], SafeUnion[Tuple[A, B], Tuple[A, C]]] = ???
c4 : Callable[[Tuple[Tuple[Callable[[A], C], Callable[[B], C]], SafeUnion[A, B]]], C] = ???
c5 : Callable[[Callable[[SafeUnion[B, C]], A]], Tuple[Callable[[B], A], Callable[[C], A]]] = ???
c6 : Never = ???

