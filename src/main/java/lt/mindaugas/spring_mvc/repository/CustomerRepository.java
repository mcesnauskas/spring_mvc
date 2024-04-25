package lt.mindaugas.spring_mvc.repository;

import lt.mindaugas.spring_mvc.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customers",
            countQuery = "SELECT count(*) FROM customers",
            nativeQuery = true)
    Page<Customer> fetchAllCustomers(Pageable pageable);
}
