package in.blockchain.we.trust.blockchain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Data data = new Data(block.getData());
        if (data.getDataType() == DataType.INCOME) {
            createPayouts((Income) data.getStoreable());
        }
    }

    public String getLastHash() {
        return getLastBlock() == null ? "" : getLastBlock().getHash();
    }

    public List<Promise> getEmployeesPromises(String employeeUuid) {
        return chain.stream()
                .map(b -> new Data(b.getData()))
                .filter(d -> d.getDataType() == DataType.PROMISE)
                .map(Data::getStoreable)
                .map(s -> (Promise) s)
                .filter(p -> p.getEmployeeUuid().equals(employeeUuid))
                .collect(Collectors.toList());
    }


    public List<Payout> getEmployeesPayouts(String employeeUuid) {
        return chain.stream()
                .map(b -> new Data(b.getData()))
                .filter(d -> d.getDataType() == DataType.PAYOUT)
                .map(Data::getStoreable)
                .map(s -> (Payout) s)
                .filter(p -> p.getEmployeeUuid().equals(employeeUuid))
                .collect(Collectors.toList());
    }


    private void createPayouts(Income income) {
        chain.stream()
                .map(b -> new Data(b.getData()))
                .filter(d -> d.getDataType() == DataType.PROMISE)
                .map(Data::getStoreable)
                .map(s -> (Promise) s)
                .map(p -> new Payout(income, p))
                .forEach(p -> addBlock(new Block(new Data(p), getLastHash())));
    }

    private Block getLastBlock() {
        return chain.isEmpty() ? null : chain.get(chain.size() - 1);
    }

    @Override
    public String toString() {
        return "{ \"chain\" : [" + chain.stream()
                .map(Block::toString)
                .collect(joining(",")) + "]}";
    }
}
