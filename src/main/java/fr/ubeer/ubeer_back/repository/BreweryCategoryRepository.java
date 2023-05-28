package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.BreweryCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryCategoryRepository extends CrudRepository<BreweryCategory, Integer> {

    BreweryCategory findByName(@Param("name") String name);
}
