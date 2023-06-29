case class CustomSet[A](private val db: scala.collection.immutable.Map[A, Boolean] = scala.collection.immutable.Map[A, Boolean]()) {}

object CustomSet {
  def empty[A](s: CustomSet[A]): Boolean = s.db.isEmpty

  def fromList[A](l: List[A]): CustomSet[A] = CustomSet(Map.from(l.map(_ -> false)))

  def member[A](s: CustomSet[A], i: A): Boolean = s.db.contains(i)

  def insert[A](s: CustomSet[A], i: A): CustomSet[A] = s.copy(db = s.db + (i -> false))

  def intersection[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = s.copy(db = s.db.filter(kv => other.db.contains(kv._1)))

  def difference[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = s.copy(db = s.db.filterNot(kv => other.db.contains(kv._1)))

  def union[A](s: CustomSet[A], other: CustomSet[A]): CustomSet[A] = s.copy(db = s.db ++ other.db)

  def isSubsetOf[A](s: CustomSet[A], other: CustomSet[A]): Boolean = s.db.forall(kv => other.db.contains(kv._1))

  def isDisjointFrom[A](s: CustomSet[A], other: CustomSet[A]): Boolean = s.db.forall(kv => !other.db.contains(kv._1))

  def isEqual[A](s: CustomSet[A], other: CustomSet[A]): Boolean = s.db == other.db
}
