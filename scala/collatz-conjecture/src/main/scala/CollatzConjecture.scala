object CollatzConjecture {
  def steps(s: Int): Option[Int] = {
    if (s <= 0) None
    else Some(Iterator.unfold(s) {
      case 1 => None
      case nonOne =>
        val calc = collatzAlgorithm(nonOne)
        Some((calc, calc))
    }.length)
  }

  private def collatzAlgorithm(n: Int): Int =
    if (n % 2 == 0) n / 2 else n * 3 + 1
}
