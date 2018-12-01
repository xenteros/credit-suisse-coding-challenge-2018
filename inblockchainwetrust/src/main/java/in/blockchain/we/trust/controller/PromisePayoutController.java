package in.blockchain.we.trust.controller;

import in.blockchain.we.trust.dto.PayoutDto;
import in.blockchain.we.trust.dto.PromiseDto;
import in.blockchain.we.trust.service.BlockchainService;
import in.blockchain.we.trust.service.ClientService;
import in.blockchain.we.trust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class PromisePayoutController {

    private BlockchainService blockchainService;
    private EmployeeService employeeService;
    private ClientService clientService;

    @Autowired
    public PromisePayoutController(BlockchainService blockchainService, EmployeeService employeeService, ClientService clientService) {
        this.blockchainService = blockchainService;
        this.employeeService = employeeService;
        this.clientService = clientService;
    }


    @GetMapping("/views/promises")
    public String getMyPromises(Model model) {
        model.addAttribute("promises",
                blockchainService.getEmployeePromises(employeeService.getLoggedUser().getUuid())
                        .stream()
                        .peek(System.out::println)
                        .map(p -> new PromiseDto(clientService.getClientName(p.getClientUuid()), p.getType().getPercentage() + "%")).collect(Collectors.toList()));
        return "promises";
    }

    @GetMapping("/views/payouts")
    public String getMyPayouts(Model model) {
        model.addAttribute("payouts",
                blockchainService.getEmployeePayouts(employeeService.getLoggedUser().getUuid())
                        .stream().map(payout -> new PayoutDto(payout.getTime(),
                        clientService.getClientName(payout.getClientUuid()), "" + payout.getAmount())).collect(Collectors.toList()));
        return "payouts";
    }


}
