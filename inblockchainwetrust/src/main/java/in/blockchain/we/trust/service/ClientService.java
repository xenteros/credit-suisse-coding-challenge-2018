package in.blockchain.we.trust.service;

import in.blockchain.we.trust.dto.ClientDto;
import in.blockchain.we.trust.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private Client loggedClient;
    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClients() {
        return clientList;
    }

    public Client getLoggedClient() {
        return loggedClient;
    }

    public Client addClient(ClientDto clientDto) {
        Client client = clientDto.toClient();
        if (this.clientList.isEmpty()) {
            this.loggedClient = client;
        }
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
