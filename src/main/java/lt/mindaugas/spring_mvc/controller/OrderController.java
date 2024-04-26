package lt.mindaugas.spring_mvc.controller;

import lt.mindaugas.spring_mvc.entity.OrderResponse;
import lt.mindaugas.spring_mvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    private String getAllOrders(
            @RequestParam(required = false) Map<String, String> requestParam,
            Model model
    ){
        OrderResponse response = (OrderResponse) orderService.getAllOrders(requestParam).getBody();
        model.addAttribute("attrOrders", response);
        return "customer/orders";
    }

    @GetMapping(path = "/{number}")
    @ResponseBody
    public ResponseEntity<?> getOrderByNumber(
            @PathVariable(name = "number") int orderNumber
    ) {
        return orderService.getOrderDetailsById(orderNumber);
    }
}
