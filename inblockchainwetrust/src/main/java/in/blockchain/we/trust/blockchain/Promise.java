package in.blockchain.we.trust.blockchain;

import com.google.gson.Gson;
import in.blockchain.we.trust.model.Client;
import in.blockchain.we.trust.model.Employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Promise implements Storeable {

    private String uuid = UUID.randomUUID().toString();
    private String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd"));    private PromiseType type;
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

    public String getTime() {
        return time;
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
        if (!(obj instanceof Promise)) {
            return false;
        }
        Promise that = (Promise) obj;

        return Objects.equals(this.getUuid(), that.getUuid());
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public DataType getDataType() {
        return DataType.PROMISE;
    }
}

