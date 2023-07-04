import scala.annotation.tailrec

case class HashItem[A](k: Int, v: A)

object HashItem {
  def fromValue[A](v: A): HashItem[A] = HashItem(k = v.hashCode(), v = v)
}

sealed trait CustomSet[+A]
case object EmptyCustomSet extends CustomSet[Nothing]
case class NonEmptyCustomSet[A](members: List[HashItem[A]]) extends CustomSet[A]

object CustomSet {
  def fromList[A](l: List[A]): CustomSet[A] = {
    @tailrec
    def go(l: List[A], accumulator: NonEmptyCustomSet[A]): CustomSet[A] = l match {
      case x :: Nil =>
        if (accumulator.members.map(_.k).contains(x.hashCode())) accumulator
        else accumulator.copy(members = accumulator.members.appended(HashItem(k = x.hashCode(), v = x)))
      case x :: xs =>
        if (accumulator.members.map(_.k).contains(x.hashCode())) accumulator
        else go(xs, accumulator.copy(members = accumulator.members.appended(HashItem(k = x.hashCode(), v = x))))
      case Nil => EmptyCustomSet
    }

    go(l, NonEmptyCustomSet(List()))
  }

  def empty[A](s: CustomSet[A]): Boolean = s == EmptyCustomSet

  def member[A](s: CustomSet[A], i: A): Boolean = s match {
    case EmptyCustomSet => false
    case NonEmptyCustomSet(members) => members.contains(HashItem.fromValue(i))
  }

  def isSubsetOf[A](s: CustomSet[A], other: CustomSet[A]): Boolean = {
    (s, other) match {
      case (EmptyCustomSet, _) => true
      case (_, EmptyCustomSet) => false
      case (NonEmptyCustomSet(r), NonEmptyCustomSet(o)) => r.forall(o.contains(_))
    }
  }

  def isDisjointFrom[A](s: CustomSet[A], other: CustomSet[A]): Boolean = {
    (s, other) match {
      case (EmptyCustomSet, _) | (_, EmptyCustomSet) => true
      case (NonEmptyCustomSet(r), NonEmptyCustomSet(o)) => r.forall(!o.contains(_))
    }
  }

  def isEqual[A](s: CustomSet[A], other: CustomSet[A]): Boolean = {
    (s, other) match {
      case (EmptyCustomSet, EmptyCustomSet) => true
      case (EmptyCustomSet, _) | (_, EmptyCustomSet) => false
      case (NonEmptyCustomSet(r), NonEmptyCustomSet(o)) => r.sortBy(_.k) == o.sortBy(_.k)
    }
  }

  def insert[A](s: CustomSet[A], i: A): CustomSet[A] =
    s match {
      case EmptyCustomSet => NonEmptyCustomSet(List[HashItem[A]](HashItem.fromValue(i)))
      case nonEmpty: NonEmptyCustomSet[A] =>
        val newItem = HashItem.fromValue(i)
        if (nonEmpty.members.map(_.k).contains(newItem.k)) nonEmpty
        else nonEmpty.copy(members = nonEmpty.members.appended(newItem))
    }

  def intersection[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = {
    (s, other) match {
      case (EmptyCustomSet, EmptyCustomSet) | (EmptyCustomSet, _) | (_, EmptyCustomSet) => EmptyCustomSet
      case (self: NonEmptyCustomSet[A], o: NonEmptyCustomSet[A]) =>
        val newList = self.members.filter(h => o.members.contains(h)).map(_.v)
        newList match {
          case xs => CustomSet.fromList(xs)
          case Nil => EmptyCustomSet
        }
    }
  }

  def difference[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = {
    (s, other) match {
      case (EmptyCustomSet, EmptyCustomSet) | (EmptyCustomSet, _) => EmptyCustomSet
      case (z: NonEmptyCustomSet[A], EmptyCustomSet) => z
      case (self: NonEmptyCustomSet[A], o: NonEmptyCustomSet[A]) =>
        val newList = self.members.filterNot(h => o.members.contains(h)).map(_.v)
        newList match {
          case xs => CustomSet.fromList(xs)
          case Nil => EmptyCustomSet
        }
    }
  }

  def union[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = {
    (s, other) match {
      case (EmptyCustomSet, EmptyCustomSet) => EmptyCustomSet
      case (z: NonEmptyCustomSet[A], EmptyCustomSet) => z
      case (EmptyCustomSet, z: NonEmptyCustomSet[A]) => z
      case (self: NonEmptyCustomSet[A], o: NonEmptyCustomSet[A]) =>
        CustomSet.fromList((self.members ++ o.members).map(_.v))
    }
  }
}
