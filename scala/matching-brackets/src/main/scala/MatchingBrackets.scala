import scala.collection.mutable

object MatchingBrackets {
  implicit class StackOps[A](s: mutable.Stack[A]) {
    def safePop(): Option[A] = {
      try {
        Some(s.pop())
      } catch {
        case _: Exception => None
      }
    }
  }

  private val associations = Map(')' -> '(', ']' -> '[', '}' -> '{')

  def isPaired(brackets: String): Boolean = {
    val stack = mutable.Stack.empty[Char]
    brackets.takeWhile {
      case open if open == '(' || open == '{' || open == '[' =>
        stack.push(open)
        true
      case close if close == ')' || close == '}' || close == ']' =>
        val opener = associations(close)
        stack.safePop() match {
          case None =>
            stack.push('p')
            false
          case Some(value) =>
            if (value == opener) true else {
              stack.push('p')
              false
            }
        }
      case _ => true
    }
    stack.isEmpty
  }
}
