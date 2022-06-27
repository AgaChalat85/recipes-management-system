package pl.agachalat.recipesmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional <Recipe> findByUserAndRcpId(Long usrId, Long rcpId);

    Optional<List<Recipe>> findAllByUser(Long usrId);

    Boolean deleteByUserAndRcpId(Long usrId, Long rcpId);

    Boolean deleteAllByUser(Long ursId);

}
