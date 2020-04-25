package pl.marcin.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.library.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {



}
