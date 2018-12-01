package in.blockchain.we.trust.blockchain;

public enum PromiseType {
    FIVE(5), TEN(10);

    private int percentage;

    PromiseType(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}
