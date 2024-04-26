class DndCharacter
  MODIFIERS = { 3 => -4, 4 => -3, 5 => -3, 6 => -2, 7 => -2, 8 => -1, 9 => -1, 10 => 0, 11 => 0, 12 => 1, 13 => 1,
                14 => 2, 15 => 2, 16 => 3, 17 => 3, 18 => 4 }.freeze

  def self.modifier(var)
    MODIFIERS[var]
  end

  attr_reader :strength, :constitution, :dexterity, :intelligence, :wisdom, :charisma, :hitpoints

  def initialize
    @strength = random_stat
    @constitution = random_stat
    @dexterity = random_stat
    @intelligence = random_stat
    @wisdom = random_stat
    @charisma = random_stat
    @hitpoints = 10 + DndCharacter.modifier(constitution)
  end

  private

  def random_stat
    [Random.rand(1..6), Random.rand(1..6), Random.rand(1..6), Random.rand(1..6)].sort[1..].sum
  end
end
