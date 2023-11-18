class AssemblyLine
  CAR_PER_HOUR = 221

  def initialize(speed)
    @speed = speed
    @fault_modifier = calculate_modifier(speed)
  end

  def production_rate_per_hour
    Float(@speed * CAR_PER_HOUR * @fault_modifier)
  end

  def working_items_per_minute
    (production_rate_per_hour / 60).floor
  end

  def calculate_modifier(value)
    case value
    when 1..4
      return 1
    when 5..8
      return 0.9
    when 9
      return 0.8
    when 10
      return 0.77
    end
  end
end
