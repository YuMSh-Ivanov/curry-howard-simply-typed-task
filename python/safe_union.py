from abc import ABCMeta as _ABCMeta, abstractmethod as _abstractmethod
from typing import TypeVar as _TypeVar, Generic as _Generic

_X = _TypeVar('_X')
_Y = _TypeVar('_Y')

class SafeUnion(_Generic[_X, _Y], metaclass=_ABCMeta):
  @property
  @_abstractmethod
  def left(self) -> _X:
    pass
  @property
  @_abstractmethod
  def right(self) -> _Y:
    pass
  @property
  @_abstractmethod
  def isLeft(self) -> bool:
    pass

class _Left(SafeUnion[_X, _Y]):
  def __init__(self, x : _X) -> None:
    self.x = x

  @property
  def left(self) -> _X:
    return self.x

  @property
  def right(self) -> _Y:
    raise RuntimeError("Getting right while left value is stored")

  @property
  def isLeft(self) -> bool:
    return True

class _Right(SafeUnion[_X, _Y]):
  def __init__(self, y) -> None:
    self.y = y

  @property
  def left(self) -> _X:
    raise RuntimeError("Getting left while right value is stored")

  @property
  def right(self) -> _Y:
    return self.y

  @property
  def isLeft(self) -> bool:
    return False

def unionLeft(x : _X) -> SafeUnion[_X, _Y]:
    return _Left(x)

def unionRight(y : _Y) -> SafeUnion[_X, _Y]:
    return _Right(y)
