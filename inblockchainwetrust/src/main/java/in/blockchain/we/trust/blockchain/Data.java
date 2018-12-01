package in.blockchain.we.trust.blockchain;

public class Data {

    private DataType dataType;
    private String data;

    public Data(Storeable storeable) {
        this.dataType = storeable.getDataType();
        this.data = storeable.toString();
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "{ \"dataType\": \"" + dataType.name() + "\",\"data\":" + data + "}";
    }
}
