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

    @Query(
            value = "SELECT (MAX(customerNumber)+1) FROM customers",
            nativeQuery = true
    )
    int autoIncrementId();

    @Query(value = "SELECT * FROM customers WHERE customerName LIKE :name AND city LIKE :city AND country LIKE :country",
            countQuery = "SELECT count(*) FROM customers WHERE customerName LIKE :name AND city LIKE :city AND country LIKE :country",
            nativeQuery = true)
    Page<Customer> searchCustomer(Pageable page, String name, String city, String country);
}
