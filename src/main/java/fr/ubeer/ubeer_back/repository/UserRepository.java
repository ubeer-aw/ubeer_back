package fr.ubeer.ubeer_back.repository;

import fr.ubeer.ubeer_back.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
