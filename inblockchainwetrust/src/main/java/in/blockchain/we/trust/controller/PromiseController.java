package in.blockchain.we.trust.controller;

import in.blockchain.we.trust.service.BlockchainService;
import in.blockchain.we.trust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromiseController {

    private BlockchainService blockchainService;
    private EmployeeService employeeService;

    @Autowired
    public PromiseController(BlockchainService blockchainService, EmployeeService employeeService) {
        this.blockchainService = blockchainService;
        this.employeeService = employeeService;
    }


    @GetMapping("/views/promises")
    public String getMyPromises(Model model) {
        model.addAttribute("promises", blockchainService.getEmployeePromises(employeeService.getLoggedUser().getUuid()));
        return "promises";
    }


}
