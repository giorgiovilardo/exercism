=begin
Write your code for the 'Hamming' exercise in this file. Make the tests in
`hamming_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/hamming` directory.
=end
module Hamming
  def self.compute(first, second)
    raise ArgumentError unless first.size == second.size
    first.chars.zip(second.chars).count { |f, s| f != s }
  end
end