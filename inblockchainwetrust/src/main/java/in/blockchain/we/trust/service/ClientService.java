package in.blockchain.we.trust.service;

import in.blockchain.we.trust.dto.ClientDto;
import in.blockchain.we.trust.model.Client;
import in.blockchain.we.trust.security.Role;
import in.blockchain.we.trust.security.UserDetailsImpl;
import in.blockchain.we.trust.security.UserDetailsServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private UserDetailsServiceImpl userDetailsService;

    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClients() {
        return clientList;
    }

    public Client getLoggedClient() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetailsImpl userDetails = (UserDetailsImpl) principal;
        if (userDetails.getRole() == Role.CLIENT) {
            return userDetails.getClient();
        }
        return null;
    }

    public Client addClient(ClientDto clientDto) {
        Client client = clientDto.toClient();
        userDetailsService.addClient(client);
        this.clientList.add(client);
        return client;
    }

    public String getClientName(String uuid) {
        for (Client client : clientList) {
            if (client.getUuid().equals(uuid)) {
                return client.getName();
            }
        }
        return null;
    }


}
