package lt.mindaugas.spring_mvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderdetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
    @Id
    @Column(name = "productcode")
    private String productCode;
    @Column(name = "ordernumber")
    private Integer orderNumber;

//    @EmbeddedId
//    private OrderDetailId orderDetailId;

    @Column(name = "quantityordered")
    private Integer quantityOrdered;
    @Column(name = "priceach")
    private Double priceEach;
    @Column(name = "orderlinenumber")
    private Integer orderLineNumber;
}
