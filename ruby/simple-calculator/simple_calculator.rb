class SimpleCalculator
  class UnsupportedOperation < StandardError
  end

  ALLOWED_OPERATIONS = ['+', '/', '*'].freeze

  def self.calculate(first_operand, second_operand, operation)
    unless ALLOWED_OPERATIONS.include? operation
      raise UnsupportedOperation.new("no")
    end


    unless first_operand.is_a?(Numeric) && second_operand.is_a?(Numeric)
      raise ArgumentError.new("bad")
    end

    case operation
    when "+"
      "#{first_operand} #{operation} #{second_operand} = #{first_operand + second_operand}"
    when "*"
      "#{first_operand} #{operation} #{second_operand} = #{first_operand * second_operand}"
    when "/"
      begin
        "#{first_operand} #{operation} #{second_operand} = #{first_operand / second_operand}"
      rescue
        "Division by zero is not allowed."
      end
    end
  end
end
