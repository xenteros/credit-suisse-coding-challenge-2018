package in.blockchain.we.trust.service;

import in.blockchain.we.trust.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private Employee logged = new Employee("Janusz", "janusz@cs.com", "password");

    public Employee getLoggedUser() {
        return logged;
    }
}
