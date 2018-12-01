package in.blockchain.we.trust.service;

import in.blockchain.we.trust.model.Employee;
import in.blockchain.we.trust.security.Role;
import in.blockchain.we.trust.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

//    private Employee logged = new Employee("Janusz", "janusz@cs.com", "password");

    public Employee getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetailsImpl userDetails = (UserDetailsImpl)principal;
        if (userDetails.getRole() == Role.EMPLOYEE) {
            return userDetails.getEmployee();
        }
        return null;
    }
}
