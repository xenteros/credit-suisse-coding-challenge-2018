package in.blockchain.we.trust.service;

import in.blockchain.we.trust.dto.ClientDto;
import in.blockchain.we.trust.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClients() {
        return clientList;
    }

    public Client addClient(ClientDto clientDto) {
        Client client = clientDto.toClient();
        this.clientList.add(client);
        return client;
    }


}
