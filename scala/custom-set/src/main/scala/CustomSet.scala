case class CustomSet[A](private val db: List[A] = List()) {
}
object CustomSet {
  def empty[A](s: CustomSet[A]): Boolean = ???
  def fromList[A](l: List[A]): CustomSet[A] = ???
  def member[A](s: CustomSet[A], i: A): Boolean = ???
  def insert[A](s: CustomSet[A], i: A): CustomSet[A] = ???
  def intersection[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = ???
  def difference[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = ???
  def union[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = ???
  def isSubsetOf[A](s: CustomSet[A], other: CustomSet[A]): Boolean = ???
  def isDisjointFrom[A](s: CustomSet[A], other: CustomSet[A]): Boolean = ???
  def isEqual[A](s: CustomSet[A], other: CustomSet[A]): Boolean = ???
}

