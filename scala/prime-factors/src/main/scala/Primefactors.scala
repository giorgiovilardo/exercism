object PrimeFactors {
  def factors(n: Int): Seq[Long] = factors(n.toLong)

  def factors(n: Long): Seq[Long] = {
    if (n <= 1) List()
    else
      Iterable.unfold((List.empty[Long], n)) {
        case (_, -1) => None
        case (divisors, value) =>
          val range = (2 to math.sqrt(value.toDouble).floor.toInt).filter(item => item % 2 == 0 || item != 2)
          val nextDivisor = range.map(value % _ == 0).zip(range).filter(_._1).map(_._2).headOption
          val newDivisors = nextDivisor match {
            case Some(divisor) => divisor.toLong :: divisors
            case None => value :: divisors
          }
          nextDivisor match {
            case Some(divisor) =>
              val newNumber = value / divisor
              Some(divisor.toLong, (newDivisors, newNumber))
            case None =>
              Some(value, (newDivisors, -1.toLong))
          }
      }.toList.sorted
  }
}
