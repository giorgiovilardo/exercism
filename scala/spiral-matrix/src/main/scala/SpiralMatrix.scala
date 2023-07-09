class Grid(side: Int) {
  var grid: Seq[Array[Int]] = (1 to side).map(_ => (1 to side).map(_ => 0).toArray)

  def print = grid.map(_.toList)

  val positions = generateCoord(side)
  var lastPositionVisited = 0

  def put(value: Int): Grid = {
    val (x, y) = positions(lastPositionVisited)
    grid(x)(y) = value
    this.lastPositionVisited += 1
    this
  }

  def generateCoord(side: Int, times: Int = 0): Seq[(Int, Int)] = {
    if (side == 0) List()
    else {
    val baseCaseOdd = List((0, 0))
      val baseCaseEven = List((0, 0), (0, 1), (1, 1), (1, 0))
      val perimeter = ((0 until side).map((0, _)) ++ (0 until side).map((_, side - 1)) ++
        (0 until side).reverse.map((side - 1, _)) ++ (0 until side).reverse.map((_, 0))).distinct
      side match {
        case 1 => baseCaseOdd.map(tuple => (tuple._1 + times, tuple._2 + times))
        case 2 => baseCaseEven.map(tuple => (tuple._1 + times, tuple._2 + times))
        case _ => perimeter.map(tuple => (tuple._1 + times, tuple._2 + times)) ++ generateCoord(side - 2, times + 1)
      }
    }
  }
}


object SpiralMatrix {
  def spiralMatrix(n: Int): Seq[Seq[Int]] = {
    val grid = new Grid(n)
    for (i <- 1 to n * n) grid.put(i)
    grid.print
  }
}
