package lt.mindaugas.spring_mvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailId implements Serializable {
    @Column(name = "productcode")
    private String productCode;
    @Column(name = "ordernumber")
    private Integer orderNumber;
}
