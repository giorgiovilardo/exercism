object ArmstrongNumbers {
  def isArmstrongNumber(n: Int): Boolean = {
    val digits = n.toString.map(_.asDigit)
    digits.map(scala.math.pow(_, digits.length).toInt).sum == n
  }
}
