package lt.mindaugas.spring_mvc.service;

import lt.mindaugas.spring_mvc.entity.Customer;
import lt.mindaugas.spring_mvc.entity.CustomerResponse;
import lt.mindaugas.spring_mvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {
    private final int defaultPage = 0;
    private final int defaultPageSize = 12;
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_PAGE_SIZE = "page_size";

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<?> getAllCustomers(Map<String, String> requestParam) {
        return fetchAllCustomersResponse(
                PageRequest.of(
                        toNumberOrDefault(requestParam.get(PARAM_PAGE), defaultPage),
                        toNumberOrDefault(requestParam.get(PARAM_PAGE_SIZE), defaultPageSize)
                )
        );
    }

    public ResponseEntity<?> getCustomerById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isEmpty()) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(customer.get());
    }

    public void createCustomer(Customer customer) {
        customer.setCustomerId(customerRepository.autoIncrementId());
        customerRepository.save(customer);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }

    private ResponseEntity<?> fetchAllCustomersResponse(Pageable page) {
        Page<Customer> pageResponse = customerRepository.fetchAllCustomers(page);
        return ResponseEntity.ok(
                new CustomerResponse(
                        pageResponse.getPageable().getPageNumber(),
                        pageResponse.getPageable().getPageSize(),
                        pageResponse.getTotalPages(),
                        pageResponse.get().toList()
                )
        );
    }

    private int toNumberOrDefault(String value, int defaultValue) {
        if (value == null) return defaultValue;
        if (value.isBlank()) return defaultValue;
        return Integer.parseInt(value);
    }

}
