=begin
Write your code for the 'Clock' exercise in this file. Make the tests in
`clock_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/clock` directory.
=end
class Clock
  def initialize(hour: 0, minute: 0)
    @minute = minute
    @hour = hour + minute / 60
    @hour %= 24
    @minute %= 60
  end

  def +(other_clock)
    self.class.new(hour: @hour + other_clock.hour, minute: @minute + other_clock.minutes)
  end

  def -(other_clock)
    self.class.new(hour: @hour - other_clock.hour, minute: @minute - other_clock.minutes)
  end

  def to_s
    format("%02d:%02d", @hour, @minute)
  end

  def ==(other_clock)
    other_clock.is_a?(Clock) ? @hour == other_clock.hour && @minute == other_clock.minutes : false
  end

  def hour
    @hour
  end

  def minutes
    @minute
  end
end