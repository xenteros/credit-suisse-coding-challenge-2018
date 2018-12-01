package in.blockchain.we.trust.blockchain;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Payout implements Storeable {

    private String uuid = UUID.randomUUID().toString();
    private String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd"));
    private String incomeUuid;
    private String promiseUuid;
    private Long amount;

    public Payout(Income income, Promise promise) {
        this.incomeUuid = income.getUuid();
        this.promiseUuid = promise.getUuid();
        this.amount = (long) (1.0 * income.getAmount() * promise.getType().getPercentage() / 100);
    }

    public String getUuid() {
        return uuid;
    }

    public String getTime() {
        return time;
    }

    public String getIncomeUuid() {
        return incomeUuid;
    }

    public String getPromiseUuid() {
        return promiseUuid;
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Payout)) {
            return false;
        }
        Payout that = (Payout) obj;

        return Objects.equals(this.getUuid(), that.getUuid());
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public DataType getDataType() {
        return DataType.PAYOUT;
    }
}

