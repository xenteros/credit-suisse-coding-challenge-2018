package in.blockchain.we.trust.blockchain;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Income implements Storeable {

    private String uuid = UUID.randomUUID().toString();
    private String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd"));
    private Long amount;
    private String clientUuid;

    public Income(Long amount, String clientUuid) {
        this.amount = amount;
        this.clientUuid = clientUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLocalDateTime() {
        return time;
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
        if (!(obj instanceof Income)) {
            return false;
        }
        Income that = (Income) obj;

        return Objects.equals(this.getUuid(), that.getUuid());
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public DataType getDataType() {
        return DataType.INCOME;
    }
}
