package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {
    List<Beer> findAllByBreweryId(Integer id);
}
