package lt.mindaugas.spring_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private String country;
}
