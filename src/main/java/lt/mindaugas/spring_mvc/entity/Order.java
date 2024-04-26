package lt.mindaugas.spring_mvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @Column(name = "ordernumber")
    private Integer orderNumber;
    @Column(name = "orderdate")
    private LocalDate orderDate;
    @Column(name = "requireddate")
    private LocalDate requiredDate;
    @Column(name = "shippeddate")
    private LocalDate shippedDate;
    @Column(name = "status")
    private String status;
    @Column(name = "comments")
    private String comments;
    @Column(name = "customernumber")
    private Integer customerNumber;
//    @Column(name = "customer_number")
//    private Integer customer_number;
}
