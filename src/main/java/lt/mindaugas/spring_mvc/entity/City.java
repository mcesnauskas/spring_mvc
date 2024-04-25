package lt.mindaugas.spring_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
    private int cityId;
	private String name;
	private String district;
}
