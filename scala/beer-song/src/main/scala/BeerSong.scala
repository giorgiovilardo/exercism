object BeerSong {
  def recite(startingBottles: Int, verses: Int): String = {
    val lastBottle = startingBottles - (verses - 1)
    (startingBottles to lastBottle by -1).map(bottleString).mkString("\n")
  }

  private def bottleString(numBottles: Int): String = {
    numBottles match {
      case 0 => "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
      case foo if foo == 1 => s"$foo bottle of beer on the wall, $foo bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
      case foo if foo == 2 => s"$foo bottles of beer on the wall, $foo bottles of beer.\nTake one down and pass it around, ${foo-1} bottle of beer on the wall.\n"
      case _ => s"$numBottles bottles of beer on the wall, $numBottles bottles of beer.\nTake one down and pass it around, ${numBottles - 1} bottles of beer on the wall.\n"
    }
  }
}
