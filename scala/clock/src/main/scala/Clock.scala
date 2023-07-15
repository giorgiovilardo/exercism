case class Clock(var hours: Int = 0, var minutes: Int = 0) {
  private var timeline: Int = 1440
  private def checkTime(): Unit = {
    timeline += ((hours % 24) * 60)
    timeline += minutes
    val correctTimeline = if (timeline >= 0) timeline % 1440 else 1440 + (timeline % 1440)
    val newHours = correctTimeline / 60
    val newMinutes = correctTimeline % 60
    hours = newHours
    minutes = newMinutes
  }
  checkTime()

  override def equals(other: Any): Boolean = {
    other match {
      case Clock(otherHours, otherMins) => this.hours == otherHours && this.minutes == otherMins
      case _ => false
    }
  }

  def +(other: Clock): Clock = {
    Clock(this.hours + other.hours, this.minutes + other.minutes)
  }

  def -(other: Clock): Clock = {
    Clock(this.hours - other.hours, this.minutes - other.minutes)
  }
}

object Clock {
  def apply(m: Int): Clock = Clock(0, m)
}
