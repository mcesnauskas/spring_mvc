package lt.mindaugas.spring_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderResponse {
    private int page;
    private int perPage;
    private int totalPage;
    private List<Order> data;
}
