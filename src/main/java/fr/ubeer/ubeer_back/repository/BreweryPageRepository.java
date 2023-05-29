package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Brewery;

import fr.ubeer.ubeer_back.entity.BreweryCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public interface BreweryPageRepository extends PagingAndSortingRepository<Brewery, Integer> {

    Page<Brewery> findAll(Pageable pageable);

    Page<Brewery> findByCategoriesInAndNameContainingIgnoreCase(
            Set<BreweryCategory> categories, String name, Pageable pageable);

    Page<Brewery> findByCategoriesIn(Set<BreweryCategory> categories, Pageable pageable);

    Page<Brewery> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
