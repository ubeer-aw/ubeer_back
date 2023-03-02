package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {
}
