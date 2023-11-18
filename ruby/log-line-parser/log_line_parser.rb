class LogLineParser
  def initialize(line)
    # @type [String]
    @line = line
    match = @line.match(/\[(?<log_level>.+)\]:\s(?<message>.+)/)
    @message = match[:message].strip
    @log_level = match[:log_level].strip.downcase
  end

  def message
    @message
  end

  def log_level
    @log_level
  end

  def reformat
    "#{@message} (#{@log_level})"
  end
end
