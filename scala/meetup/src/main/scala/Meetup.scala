import Meetup.allDaysInAMonth

import java.time.{DayOfWeek, LocalDate}
import Schedule.Schedule


case class Meetup(month: Int, year: Int) {
  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = {
    val allMonth = allDaysInAMonth(LocalDate.of(year, month, 1)).filter(_.getDayOfWeek.getValue == dayOfWeek)
    schedule match {
      case Schedule.Teenth => allMonth.find(day => (13 to 19).contains(day.getDayOfMonth)).get
      case Schedule.First => allMonth.head
      case Schedule.Second => allMonth(1)
      case Schedule.Third => allMonth(2)
      case Schedule.Fourth => allMonth(3)
      case Schedule.Last => allMonth.takeRight(1).head
    }
  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue

  def allDaysInAMonth(localDate: LocalDate): Seq[LocalDate] = {
    for (day <- 1 to localDate.lengthOfMonth) yield LocalDate.of(localDate.getYear, localDate.getMonth, day)
  }
}
