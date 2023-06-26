object Leap {
  def leapYear(year: Int): Boolean =
    year match {
      case leap if leap % 400 == 0 => true
      case leap if leap % 4 == 0 && leap % 100 != 0 => true
      case _ => false
    }
}
