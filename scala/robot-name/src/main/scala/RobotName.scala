class Robot {
  private var _name = NameGenerator.getName
  def name: String = _name
  def reset(): Unit = {_name = NameGenerator.getName}
}


class NameGenerator {
  private var firstCharacterPosition = 0
  private var secondCharacterPosition = 0
  private var numericCounterValue = 0
  def generate: String = {
    val alphabet = 'A' to 'Z'
    val name = s"${alphabet(firstCharacterPosition)}${alphabet(secondCharacterPosition)}${numericCounterValue.toString.reverse.padTo(3, '0').reverse}"
    numericCounterValue += 1
    if (numericCounterValue == 999) secondCharacterPosition += 1
    if (secondCharacterPosition == 26) firstCharacterPosition += 1
    name
  }
}
object NameGenerator {
  private var instance = new NameGenerator
  def getName: String = this.synchronized { instance.generate }
}
