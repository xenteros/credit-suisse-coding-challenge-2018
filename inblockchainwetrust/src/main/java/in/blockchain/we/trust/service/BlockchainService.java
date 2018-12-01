package in.blockchain.we.trust.service;

import in.blockchain.we.trust.blockchain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockchainService {

    private Chain chain = new Chain();

    public void addStoreable(Storeable storeable) {
        chain.addBlock(new Block(new Data(storeable), chain.getLastHash()));
    }

    public List<Promise> getEmployeePromises(String employeeUuid) {
        return chain.getEmployeesPromises(employeeUuid);
    }




}
