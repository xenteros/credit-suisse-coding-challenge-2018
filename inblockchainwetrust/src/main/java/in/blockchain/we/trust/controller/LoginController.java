package in.blockchain.we.trust.controller;

import in.blockchain.we.trust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {

    private EmployeeService employeeService;

    @Autowired
    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        if (employeeService.getLoggedUser() != null) {
            return "home";
        } else {
            return "buy";
        }
    }

}
