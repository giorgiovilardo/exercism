object Acronym {
  def abbreviate(phrase: String): String = {
    phrase.split(Array('-', ' ')).map(_.take(1)).mkString.toUpperCase
  }
}
