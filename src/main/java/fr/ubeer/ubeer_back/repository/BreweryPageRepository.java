package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Brewery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryPageRepository extends PagingAndSortingRepository<Brewery, Integer> {

    Page<Brewery> findAll(Pageable pageable);
}
