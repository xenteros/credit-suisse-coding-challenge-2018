package in.blockchain.we.trust.dto;

public class PayoutDto {

    private String date;
    private String client;
    private String amount;

    public PayoutDto() {
    }

    public PayoutDto(String date, String client, String amount) {
        this.date = date;
        this.client = client;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
