package pl.marcin.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.library.model.Order;

public interface OrderRepository extends CrudRepository<Order,Long > {

}
