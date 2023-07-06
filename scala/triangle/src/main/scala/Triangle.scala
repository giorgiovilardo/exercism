case class Triangle(a: Double, b: Double, c: Double) {
  def equilateral: Boolean = ???
  def isosceles: Boolean = ???
  def scalene: Boolean = ???
}
object Triangle {
  def apply(a: Int, b: Int, c: Int): Triangle = Triangle(a.toDouble, b.toDouble, c.toDouble)
}
