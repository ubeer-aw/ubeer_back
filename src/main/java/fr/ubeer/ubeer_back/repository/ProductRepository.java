package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByBreweryId(Integer id);
}
