package in.blockchain.we.trust.blockchain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Chain {

    private List<Block> chain = new ArrayList<>();

    public boolean isValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public void addBlock(Block block) {
        this.chain.add(block);
        if (!isValid()) {
            this.chain.remove(this.chain.size() - 1);
            throw new RuntimeException("Block doesn't match the blockchain");
        }
    }

    public Block getLastBlock() {
        return chain.isEmpty() ? null : chain.get(chain.size() - 1);
    }

    public String getLastHash() {
        return getLastBlock() == null ? "" : getLastBlock().getHash();
    }

    @Override
    public String toString() {
        return "{ \"chain\" : [" + chain.stream()
                .map(Block::toString)
                .collect(joining(",")) + "]}";
    }
}
