package in.blockchain.we.trust.controller;

import in.blockchain.we.trust.blockchain.Income;
import in.blockchain.we.trust.blockchain.Promise;
import in.blockchain.we.trust.blockchain.PromiseType;
import in.blockchain.we.trust.dto.ClientDto;
import in.blockchain.we.trust.model.Client;
import in.blockchain.we.trust.service.BlockchainService;
import in.blockchain.we.trust.service.ClientService;
import in.blockchain.we.trust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    private ClientService clientService;
    private BlockchainService blockchainService;
    private EmployeeService employeeService;

    @Autowired
    public ClientController(ClientService clientService, BlockchainService blockchainService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.blockchainService = blockchainService;
        this.employeeService = employeeService;
    }

    @GetMapping("/views/clients")
    public String getClients(Model model) {
        model.addAttribute("clients", clientService.getClients());
        return "clients";
    }

    @GetMapping("/views/add-client")
    public String addClientView(Model model) {
        model.addAttribute("client", new ClientDto());
        return "add-client";
    }

    @PostMapping("/api/clients")
    public String addClient(@ModelAttribute ClientDto client, Model model) {
        Client created = clientService.addClient(client);
        blockchainService.addStoreable(new Promise(PromiseType.FIVE, created, employeeService.getLoggedUser()));
        model.addAttribute("clients", clientService.getClients());
        return "clients";
    }

    @GetMapping("/views/buy")
    public String buy(Model model) {
        return "buy";
    }


    @GetMapping("/api/buy/trial")
    public String trial(Model model) {
        blockchainService.addStoreable(new Income(100L, clientService.getLoggedClient().getUuid()));
        return "buy";
    }


    @GetMapping("/api/buy/full")
    public String full(Model model) {
        blockchainService.addStoreable(new Income(10000L, clientService.getLoggedClient().getUuid()));
        return "buy";
    }

}
