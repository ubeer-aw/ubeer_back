package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
