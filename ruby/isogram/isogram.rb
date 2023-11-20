=begin
Write your code for the 'Isogram' exercise in this file. Make the tests in
`isogram_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/isogram` directory.
=end
module Isogram
  # @param value [String]
  def self.isogram?(value)
    return value if value == ""

    value
      .downcase
      .gsub(/\W+/, "")
      .chars
      .tally
      .values
      .uniq
      .length == 1
  end
end