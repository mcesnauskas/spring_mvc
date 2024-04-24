package lt.mindaugas.spring_mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/home")
    public String getHome(HttpServletRequest request, Model model){
        String host = request.getServerName();
        int port = request.getServerPort();
        String baseUrl = "http://" + host + ":" + port;

        model.addAttribute("attrName", "Welcome home!");
        model.addAttribute("attrLink", baseUrl + "/test");
        return "home";
    }

    @GetMapping("/test")
    public String getTest(){
        return "common/test";
    }
}
