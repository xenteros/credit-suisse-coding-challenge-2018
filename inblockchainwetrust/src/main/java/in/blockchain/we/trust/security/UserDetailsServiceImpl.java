package in.blockchain.we.trust.security;

import in.blockchain.we.trust.model.Client;
import in.blockchain.we.trust.model.Employee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class UserDetailsServiceImpl implements UserDetailsService {

    private Map<String, UserDetails> users = new HashMap<>();

    public UserDetailsServiceImpl() {
        users.put("Janush", new UserDetailsImpl("Janush", "password", Role.EMPLOYEE, new Employee("Janush", "janush@cs.com"), null));
        users.put("Grazyna", new UserDetailsImpl("Grazyna", "pass", Role.EMPLOYEE, new Employee("Grazyna", "grazyna@cs.com"), null));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (users.containsKey(username)) {
            return users.get(username);
        }
        throw new UsernameNotFoundException(username);
    }

    public void addClient(Client client) {
        this.users.put(client.getName(), new UserDetailsImpl(client.getName(), "1234", Role.CLIENT, null, client));
    }
}
