package pl.agachalat.recipesmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import pl.agachalat.recipesmanagementsystem.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);
}
