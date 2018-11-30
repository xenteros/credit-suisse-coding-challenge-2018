package in.blockchain.we.trust.model;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Income {

    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime localDateTime = LocalDateTime.now();
    private Long amount;
    private String clientUuid;

    public Income(Long amount, String clientUuid) {
        this.amount = amount;
        this.clientUuid = clientUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Long getAmount() {
        return amount;
    }

    public String getClientUuid() {
        return clientUuid;
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
