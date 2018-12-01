package in.blockchain.we.trust.dto;

public class PromiseDto {

    private String clientName;
    private String provision;

    public PromiseDto() {
    }

    public PromiseDto(String clientName, String provision) {
        this.clientName = clientName;
        this.provision = provision;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProvision() {
        return provision;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setProvision(String provision) {
        this.provision = provision;
    }
}
