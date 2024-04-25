package lt.mindaugas.spring_mvc.controller;

import lt.mindaugas.spring_mvc.entity.Address;
import lt.mindaugas.spring_mvc.entity.City;
import lt.mindaugas.spring_mvc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        String someStyle = "border border-2 border-primary rounded-2 px-3";

        model.addAttribute("attrPerson", person);
        model.addAttribute("attrPerson02", person2);
        model.addAttribute("attrHobbies", hobbies);
        model.addAttribute("attrStyle", someStyle);
        model.addAttribute("attrLocalDate", LocalDate.now());
        model.addAttribute("attrLocalDateTime", LocalDateTime.now());

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

    @GetMapping(path = "/city")
    public String getCity(Model model){

        City city01 = new City(1, "London", "Ruislip");
        City city02 = new City(2, "Vilnius", "Karoliniskes");
        City city03 = new City(3, "Dublin", "Castleknock");
        City city04 = new City(4, "Riga", "Center");

        List<City> listOfCities = List.of(city01, city02, city03, city04);

        model.addAttribute("attrListOfCities", listOfCities);

        return "common/city";
    }
}
