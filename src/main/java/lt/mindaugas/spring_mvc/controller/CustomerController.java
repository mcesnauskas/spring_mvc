package lt.mindaugas.spring_mvc.controller;

import lt.mindaugas.spring_mvc.entity.CustomerResponse;
import lt.mindaugas.spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    private String getAllCustomers(
            @RequestParam(required = false) Map<String, String> requestParam,
            Model model
    ){
        CustomerResponse response = (CustomerResponse) customerService.getAllCustomers(requestParam).getBody();
        model.addAttribute("attrCustomers", response);
        return "customer/customers";
    }
}
