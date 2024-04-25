package lt.mindaugas.spring_mvc.controller;

import lt.mindaugas.spring_mvc.entity.Address;
import lt.mindaugas.spring_mvc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/common")
public class DemoController {

    @GetMapping(path = "/demo")
    public String getDemo(Model model){
        List<String> hobbies = List.of("cooking", "running", "dancing", "coding");

        Person person = new Person(
                1, "Penelope", "Cruz", "penelope@gmail.com", "USA", hobbies
        );

        Person person2 = new Person();

        model.addAttribute("attrPerson", person);
        model.addAttribute("attrPerson02", person2);
        model.addAttribute("attrHobbies", hobbies);

        return "common/demo";
    }

    @GetMapping(path = "/address")
    public String getAddress(Model model){

        Address address01 = new Address("123 Maple Street", null,
                "Springfield", "12345", "United States");

        Address address02 = new Address("10 Downing Street", "Westminster", "London", "SW1A 2AA", "United Kingdom");

        model.addAttribute("attrAddress", address01);
        model.addAttribute("attrAddress02", address02);

        return "common/address";
    }
}
