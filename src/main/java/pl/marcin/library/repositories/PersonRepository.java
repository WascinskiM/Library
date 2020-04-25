package pl.marcin.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.library.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
