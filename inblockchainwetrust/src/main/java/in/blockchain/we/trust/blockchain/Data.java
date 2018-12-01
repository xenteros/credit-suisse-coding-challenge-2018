package in.blockchain.we.trust.blockchain;

import com.google.gson.Gson;

public class Data {

    private DataType dataType;
    private String data;

    public Data(Storeable storeable) {
        this.dataType = storeable.getDataType();
        this.data = storeable.toString();
    }

    public Data(String json) {
        Gson gson = new Gson();
        Data that = gson.fromJson(json, Data.class);
        this.dataType = that.dataType;
        this.data = that.data;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getData() {
        return data;
    }

    public Storeable getStoreable() {
        Gson gson = new Gson();
        if (dataType == DataType.PROMISE) {
            return gson.fromJson(data, Promise.class);
        }
        if (dataType == DataType.PAYOUT) {
            return gson.fromJson(data, Payout.class);
        }
        if (dataType == DataType.INCOME) {
            return gson.fromJson(data, Income.class);
        }
        throw new RuntimeException();
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
//        return "{ \"dataType\": \"" + dataType.name() + "\",\"data\":" + data + "}";
    }
}
