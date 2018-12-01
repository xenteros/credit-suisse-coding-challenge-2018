package in.blockchain.we.trust;

import in.blockchain.we.trust.security.UserDetailsServiceImpl;
import in.blockchain.we.trust.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
class Application {



    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        UserDetailsServiceImpl userDetailsService = ctx.getBean(UserDetailsServiceImpl.class);
        ClientService clientService = ctx.getBean(ClientService.class);
        clientService.setUserDetailsService(userDetailsService);
    }


}
