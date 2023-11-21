class LocomotiveEngineer
  def self.generate_list_of_wagons(*wagon_ids)
    wagon_ids
  end

  def self.fix_list_of_wagons(each_wagons_id, missing_wagons)
    first, second, new_first, *rest = each_wagons_id
    [new_first, *missing_wagons, *rest, first, second]
  end

  def self.add_missing_stops(from_to_hash, **stops)
    {**from_to_hash, stops: [*stops.values]}
  end

  def self.extend_route_information(route, more_route_information)
    {**route, **more_route_information}
  end
end
