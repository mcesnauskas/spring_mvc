package lt.mindaugas.spring_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private List<String> hobbies;
}
