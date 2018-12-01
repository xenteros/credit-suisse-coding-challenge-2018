package in.blockchain.we.trust.dto;

import com.google.gson.Gson;
import in.blockchain.we.trust.model.Client;

public class ClientDto {

    private String name;
    private String contactPerson;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Client toClient() {
        return new Client(this.name, this.contactPerson, this.email);
    }
}
