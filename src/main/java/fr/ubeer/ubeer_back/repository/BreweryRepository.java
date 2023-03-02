package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Brewery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryRepository extends CrudRepository<Brewery, Integer> {
}
