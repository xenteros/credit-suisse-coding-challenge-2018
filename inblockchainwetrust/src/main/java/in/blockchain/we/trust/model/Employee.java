package in.blockchain.we.trust.model;

import com.google.gson.Gson;

import java.util.Objects;
import java.util.UUID;

public class Employee {

    private String uuid = UUID.randomUUID().toString();
    private String name;
    private String email;
    private transient String password;

    public Employee(String uuid, String name, String email, String password) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Employee(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee that = (Employee) obj;

        return Objects.equals(this.getUuid(), that.getUuid());
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
