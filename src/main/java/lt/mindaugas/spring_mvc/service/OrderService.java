package lt.mindaugas.spring_mvc.service;

import lt.mindaugas.spring_mvc.entity.Order;
import lt.mindaugas.spring_mvc.entity.OrderDetails;
import lt.mindaugas.spring_mvc.entity.OrderResponse;
import lt.mindaugas.spring_mvc.repository.OrderDetailsRepository;
import lt.mindaugas.spring_mvc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {
    private final int defaultPage = 0;
    private final int defaultPageSize = 12;
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_PAGE_SIZE = "page_size";

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public ResponseEntity<?> getAllOrders(Map<String, String> requestParam) {
        return fetchAllOrdersResponse(
                PageRequest.of(
                        toNumberOrDefault(requestParam.get(PARAM_PAGE), defaultPage),
                        toNumberOrDefault(requestParam.get(PARAM_PAGE_SIZE), defaultPageSize)
                )
        );
    }

    // Test
    public ResponseEntity<?> getOrderDetailsById(int orderNumber) {
        List<OrderDetails> order = (List<OrderDetails>) orderDetailsRepository.fetchOrderDetailsByOrderID(orderNumber);

        if (order.isEmpty()) {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(order);
    }

    private ResponseEntity<?> fetchAllOrdersResponse(Pageable page) {
        Page<Order> pageResponse = orderRepository.fetchAllOrders(page);
        return ResponseEntity.ok(
                new OrderResponse(
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
