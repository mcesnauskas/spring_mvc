package lt.mindaugas.spring_mvc.repository;

import lt.mindaugas.spring_mvc.entity.Order;
import lt.mindaugas.spring_mvc.entity.OrderDetailId;
import lt.mindaugas.spring_mvc.entity.OrderDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, String> {
    @Query(
            value = "SELECT * FROM orderdetails WHERE orderNumber = :id",
            nativeQuery = true
    )
    Iterable<OrderDetails> fetchOrderDetailsByOrderID(int id);
}
