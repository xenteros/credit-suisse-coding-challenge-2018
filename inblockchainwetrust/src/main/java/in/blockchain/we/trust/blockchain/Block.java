package in.blockchain.we.trust.blockchain;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Objects;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;


    @Override
    public String toString() {
        return "{" +
                "\"hash\":\"" + hash + "\"," +
                "\"previousHash\":\"" + previousHash + "\"," +
                "\"data\":" + data +"," +
                "\"timestamp\":\"" + timestamp+ "\"}";

    }

    public Block(Data data, String previousHash) {
        Instant instant = Instant.now();
        this.data = data.toString();
        this.previousHash = previousHash;
        this.timestamp = instant.toEpochMilli();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return Hashing.sha512()
                .hashString(prepareString(), StandardCharsets.UTF_8)
                .toString();
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    private String prepareString() {
        return this.previousHash + this.data + this.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.calculateHash());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Block)) {
            return false;
        }
        Block that = (Block)obj;
        return Objects.equals(this.calculateHash(), that.calculateHash());
    }
}
