package lt.mindaugas.spring_mvc.controller;

import lt.mindaugas.spring_mvc.entity.Customer;
import lt.mindaugas.spring_mvc.entity.CustomerResponse;
import lt.mindaugas.spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("attrSearchCustomer", new Customer());
        return "customer/customers";
    }

    @PostMapping(path = "/search")
    private String searchCustomers(
            @ModelAttribute("attrSearchCustomer") Customer searchCustomer,
            @RequestParam(required = false) Map<String, String> requestParam,
            Model model
    ){
        CustomerResponse response =
                (CustomerResponse) customerService.searchCustomers(requestParam, searchCustomer).getBody();
        model.addAttribute("attrCustomers", response);
        model.addAttribute("attrSearchCustomer", searchCustomer);
        return "customer/customers";
    }

    @GetMapping(path = "/{id}/details")
//    @GetMapping(path = "/{id}")
    public String getCustomerById(
            @PathVariable(name = "id") int customerId,
            Model model
    ) {
        Customer customer = (Customer) customerService.getCustomerById(customerId).getBody();
        model.addAttribute("attrCustomer", customer);
        model.addAttribute("attrClassDisplay", "d-none");
        return "customer/customer";
    }

    @PostMapping(path = "/{id}/details")
//    @PostMapping(path = "/{id:\\d+}")
    public String postCustomerById(
            @ModelAttribute("attrCustomer") Customer customer,
            Model model
    ) {
        customerService.saveCustomer(customer);
        model.addAttribute("attrCustomer", customer);
        model.addAttribute("attrMessage", "Customer successfully updated!");
        model.addAttribute("attrClassDisplay", "d-block");
        return "customer/customer";
    }

    @PostMapping(path = "/{id}/delete")
    public String deleteCustomerById(
            @PathVariable(name = "id") int customerId,
            @ModelAttribute("attrCustomer") Customer customer
    ) {
        customerService.deleteCustomerById(customerId);
        return "redirect:/customers";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addCustomer(Model model){
        model.addAttribute("attrCustomer", new Customer());
        model.addAttribute("attrClassDisplay", "d-none");
        return "customer/customer";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("attrCustomer") Customer customer, Model model){
        customerService.createCustomer(customer);
        model.addAttribute("attrCustomer", customer);
        model.addAttribute("attrMessage", "New customer Created!");
        model.addAttribute("attrClassDisplay", "d-block");
        return "customer/customer";
    }
}
