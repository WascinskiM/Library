package pl.marcin.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.library.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {



}
