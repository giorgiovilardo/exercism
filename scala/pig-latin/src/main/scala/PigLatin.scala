object PigLatin {
  private val startsWithConsonant = "([^aeiou]*)(.*)".r
  private val startsWithConsonantFollowedByQu = "([^aeiou]*qu)(.*)".r
  private val startsWithVowelSound = "([aeiou]|xr|yt)(.*)".r
  private val hasYAsSecondConsonantBlock = "([^aeiouy]+)(y.*)".r

  def translate(s: String): String = {
    s.split(' ').map {
      case startsWithVowelSound(x, xs) => s"${x}${xs}ay"
      case hasYAsSecondConsonantBlock(x, xs) => s"$xs${x}ay"
      case startsWithConsonantFollowedByQu(x, xs) => s"$xs${x}ay"
      case startsWithConsonant(x, xs) => s"$xs${x}ay"
      case _ => s
    }.mkString(" ")
  }
}
