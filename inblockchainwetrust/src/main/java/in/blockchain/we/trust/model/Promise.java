package in.blockchain.we.trust.model;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Promise {

    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime localDateTime = LocalDateTime.now();
    private PromiseType type;
    private String clientUuid;
    private String employeeUuid;

    public Promise(PromiseType type, Client client, Employee employee) {
        this.type = type;
        this.clientUuid = client.getUuid();
        this.employeeUuid = employee.getUuid();
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public PromiseType getType() {
        return type;
    }

    public String getClientUuid() {
        return clientUuid;
    }

    public String getEmployeeUuid() {
        return employeeUuid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this, obj);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

