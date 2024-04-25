package lt.mindaugas.spring_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CustomerResponse {
    private int page;
    private int perPage;
    private int totalPage;
    private List<Customer> data;
}
