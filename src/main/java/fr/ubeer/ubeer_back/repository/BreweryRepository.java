package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreweryRepository extends CrudRepository<Brewery, Integer> { }
