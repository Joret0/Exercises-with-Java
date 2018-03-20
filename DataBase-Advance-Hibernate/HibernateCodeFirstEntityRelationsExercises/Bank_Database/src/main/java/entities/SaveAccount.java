package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "save_account")
public class SaveAccount extends BaseAccount{
    @Column(name = "rate")
    private BigDecimal rate;

    public SaveAccount() {
    }

    public SaveAccount(String accountNumber, BigDecimal balance, BigDecimal rate) {
        super(accountNumber, balance);
        this.rate = rate;
    }

    public void addInterest() {
        BigDecimal bd = this.getBalance();
        bd = bd.add(bd.multiply(this.rate));
        this.setBalance(bd);
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
