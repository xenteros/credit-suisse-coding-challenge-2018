package in.blockchain.we.trust.model;

import com.google.gson.Gson;

import java.util.Objects;
import java.util.UUID;

public class Client {

    private String uuid = UUID.randomUUID().toString();
    private String name;

    public Client(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Client(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Client)) {
            return false;
        }
        Client that = (Client) obj;

        return Objects.equals(this.getUuid(), that.getUuid());
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
