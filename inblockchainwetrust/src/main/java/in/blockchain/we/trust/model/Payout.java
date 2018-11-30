package in.blockchain.we.trust.model;

import com.google.gson.Gson;

import java.util.Objects;
import java.util.UUID;

public class Payout {

    private String uuid = UUID.randomUUID().toString();
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
        return Objects.equals(this, obj);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

