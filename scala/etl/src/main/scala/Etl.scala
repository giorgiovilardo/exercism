object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] =
    scoreMap.flatMap{ case (k, v) => v.map(_.toLowerCase -> k) }
}
