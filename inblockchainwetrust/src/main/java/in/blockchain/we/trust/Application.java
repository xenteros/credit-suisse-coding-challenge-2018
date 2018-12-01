package in.blockchain.we.trust;

import in.blockchain.we.trust.blockchain.*;
import in.blockchain.we.trust.model.Client;
import in.blockchain.we.trust.model.Employee;

class Application {

    public static void main(String[] args) {
        Employee grazyna = new Employee("Grazyna", "grazyna@gmail.com", "password");
        Client cs = new Client("Credit Suisse");
        Chain chain = new Chain();
        Promise promise = new Promise(PromiseType.FIVE, cs, grazyna);
        Income income = new Income(1000L, grazyna.getUuid());
        Payout payout = new Payout(income, promise);
        chain.addBlock(new Block(new Data(promise), chain.getLastHash()));
        chain.addBlock(new Block(new Data(income), chain.getLastHash()));
        chain.addBlock(new Block(new Data(payout), chain.getLastHash()));
        System.out.println(chain);
    }
}
