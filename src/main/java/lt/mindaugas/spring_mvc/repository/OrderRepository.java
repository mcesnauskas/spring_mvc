package lt.mindaugas.spring_mvc.repository;

import lt.mindaugas.spring_mvc.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT * FROM orders",
            countQuery = "SELECT count(*) FROM orders",
            nativeQuery = true)
    Page<Order> fetchAllOrders(Pageable pageable);
}
