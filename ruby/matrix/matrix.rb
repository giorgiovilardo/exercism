=begin
Write your code for the 'Matrix' exercise in this file. Make the tests in
`matrix_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/matrix` directory.
=end
class Matrix
  def initialize(vals)
    @matrix = vals.split("\n").map{|item| item.split.map(&:to_i)}
    p @matrix
  end

  def row(row)
    @matrix[row-1]
  end

  def column(column)
    @matrix.map { |item| item[column - 1] }
  end
end