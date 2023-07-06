case class Triangle(a: Double, b: Double, c: Double) {
  private def sidesSet = Set() + a + b + c
  private def isLegal = {
    val sides = List(a,b,c).zipWithIndex
    val allMoreThanZero = sides.forall(_._1 > 0)
    val allRespectsTriangleInequality = sides.map(item => (item._1, sides.filter(tuple => tuple._2 != item._2).map(_._1).sum)).forall(s => s._1 < s._2)
    allMoreThanZero && allRespectsTriangleInequality
  }
  def equilateral: Boolean = sidesSet.size == 1 && isLegal
  def isosceles: Boolean = sidesSet.size != 3 && isLegal
  def scalene: Boolean = sidesSet.size == 3 && isLegal
}
object Triangle {
  def apply(a: Int, b: Int, c: Int): Triangle = Triangle(a.toDouble, b.toDouble, c.toDouble)
}
