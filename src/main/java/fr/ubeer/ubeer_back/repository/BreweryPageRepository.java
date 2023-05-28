package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Brewery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BreweryPageRepository extends PagingAndSortingRepository<Brewery, Integer> {

    @Query("SELECT b FROM Brewery b " +
            "LEFT JOIN b.categories bc " +
            "WHERE (:stars IS NULL OR b.stars >= :stars) " +
            "AND (:categories IS NULL OR bc.name IN (:categories))")
    Page<Brewery> findAll(@Param("stars") Double stars,
                                           @Param("categories") String categories,
                                           Pageable pageable);
}
