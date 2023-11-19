module Port
  IDENTIFIER = :PALE

  def self.get_identifier(city)
    city[0..3].upcase.to_sym
  end

  def self.get_terminal(ship_identifier)
    cargo_type = ship_identifier[0..2]
    (cargo_type == "OIL" || cargo_type == "GAS") ? :A : :B
  end
end
