object SecretHandshake {
  private val bitFieldsValue = List("invert", "jump", "close your eyes", "double blink", "wink")
  private def commandParser(commandString: String) = {
    commandString.zip(bitFieldsValue).collect { case (flag, command) if flag == '1' => command }.reverse.toList
  }

  def commands(v: Int): List[String] = {
    val commands = commandParser(v.toBinaryString.reverse.padTo(5, '0').reverse)
    if (commands.contains("invert")) commands.filter(_ != "invert").reverse else commands
  }
}
