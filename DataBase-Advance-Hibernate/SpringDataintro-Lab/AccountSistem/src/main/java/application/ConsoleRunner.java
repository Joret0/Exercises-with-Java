package application;

import application.models.Account;
import application.models.User;
import application.services.account.AccountServiceImpl;
import application.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner{
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUserName("Georgi Ivanov Stalev");
        user.setAge(20);

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));
        account.setUser(user);

        Set<Account> accounts = new HashSet<Account>();
        accounts.add(account);
        user.setAccounts(accounts);
        userService.registerUser(user);

        accountService.withdrawMoney(new BigDecimal(20000), account.getId());
        accountService.transferMoney(new BigDecimal(20000), 1L);
    }
}
