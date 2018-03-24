package application.services.account;

import application.models.Account;
import application.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        if (!this.accountRepository.exists(id)) {
        throw new IllegalArgumentException("There is no account with this ID!");
        }

        Account account = accountRepository.findOne(id);
        BigDecimal newBalance = account.getBalance().subtract(money);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Not enough money in the account!");
        } else {
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account = accountRepository.findOne(id);

        if (account == null) {
            throw new IllegalArgumentException("Account with this ID not exist!");
        }

        if (account.getUser() == null) {
            throw new IllegalArgumentException("This account has no User!");
        }

        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount for the transfer can not be negative!");
        }

        BigDecimal newBalance = account.getBalance().add(money);
        account.setBalance(newBalance);
    }
}
