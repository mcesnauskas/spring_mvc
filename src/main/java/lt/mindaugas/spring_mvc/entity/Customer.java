package lt.mindaugas.spring_mvc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name = "customernumber")
    private Integer customerId;
    @Column(name = "customername")
    private String customerName;
    @Column(name = "contactlastname")
    private String contactLastName;
    @Column(name = "contactfirstname")
    private String contactFirstName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "addressline1")
    private String addressLine1;
    @Column(name = "addressline2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postalcode")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "creditlimit")
    private Double creditLimit;
}
