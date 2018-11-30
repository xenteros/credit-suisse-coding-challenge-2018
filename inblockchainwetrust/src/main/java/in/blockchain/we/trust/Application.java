package in.blockchain.we.trust;

import in.blockchain.we.trust.model.Employee;

class Application {

    public static void main(String[] args) {
        Employee employee = new Employee("Danuta Nowak", "danuta.nowak@gmail.com", "password");
        System.out.println(employee);
    }
}
