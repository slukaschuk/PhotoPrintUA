package ua.com.spiritus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.spiritus.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{
}
