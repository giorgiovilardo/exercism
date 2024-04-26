=begin
Write your code for the 'Reverse String' exercise in this file. Make the tests in
`reverse_string_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/reverse-string` directory.
=end
class Reverser
  def initialize(string)
    @string = string
  end

  def reverse
    @string.reverse
  end

  def self.reverse(string)
    new(string).reverse
  end
end