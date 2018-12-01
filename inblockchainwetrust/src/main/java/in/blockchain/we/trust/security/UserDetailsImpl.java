package in.blockchain.we.trust.security;

import in.blockchain.we.trust.model.Client;
import in.blockchain.we.trust.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private Role role;
    private Employee employee;
    private Client client;

    public UserDetailsImpl() {

    }

    public UserDetailsImpl(String username, String password, Role role, Employee employee, Client client) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.employee = employee;
        this.client = client;
    }

    public Role getRole() {
        return role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
