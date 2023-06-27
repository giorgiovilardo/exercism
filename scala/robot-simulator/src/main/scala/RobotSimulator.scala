import Bearing.Bearing

object Bearing extends Enumeration {
  type Bearing = Value
  val North, South, West, East = Value
  def turnRight(from: Bearing): Bearing =
    from match {
      case North => East
      case South => West
      case West => North
      case East => South
    }
  def turnLeft(from: Bearing): Bearing =
    from match {
      case North => West
      case South => East
      case West => South
      case East => North
    }
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  def turnRight: Robot = this.copy(bearing=Bearing.turnRight(bearing))
  def turnLeft: Robot = this.copy(bearing=Bearing.turnLeft(bearing))
  def advance: Robot = this.copy(coordinates=coordinateUpdater)
  def simulate(commands: String): Robot = simulator(commands)

  private def coordinateUpdater: (Int, Int) = {
    val (x, y) = this.coordinates
    this.bearing match {
      case Bearing.North => (x, y + 1)
      case Bearing.South => (x, y - 1)
      case Bearing.West => (x - 1, y)
      case Bearing.East => (x + 1, y)
    }
  }

  private def simulator(commands: String): Robot = {
    commands.foldLeft(this)((robot, command) => command match {
      case 'L' => robot.turnLeft
      case 'R' => robot.turnRight
      case 'A' => robot.advance
    })
  }
}
