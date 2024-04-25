package lt.mindaugas.spring_mvc.controller;

import lt.mindaugas.spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseBody
    private ResponseEntity<?> getAllCustomers(
            @RequestParam(required = false) Map<String, String> requestParam
    ){
        return customerService.getAllCustomers(requestParam);
    }
}
