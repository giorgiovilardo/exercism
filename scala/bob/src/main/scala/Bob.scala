object Bob {
  implicit class StringExtensions(val s: String) {
    def isUpper: Boolean = {
      val onlyLetters = s.filter(_.isLetter)
      onlyLetters.toUpperCase == onlyLetters && onlyLetters.nonEmpty
    }
  }

  def response(statement: String): String = {
    statement.trim match {
      case s"${sentence}?" if sentence.isUpper => "Calm down, I know what I'm doing!"
      case s"${_}?" => "Sure."
      case sentence if sentence.isUpper => "Whoa, chill out!"
      case sentence if sentence.filterNot(_.isWhitespace) == "" => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }
}
