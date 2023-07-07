object PascalsTriangle {
  def rows(count: Int): Seq[Seq[Int]] =
    Vector.iterate(Vector(1), count) {
      row => 0 +: row zip row :+ 0 map Function.tupled(_ + _)
    }
}
