package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "check_account")
public class CheckAccount extends BaseAccount{

    private BigDecimal fee;

    public CheckAccount() {
    }

    public CheckAccount(String accountNumber, BigDecimal balance, BigDecimal fee) {
        super(accountNumber, balance);
        this.fee = fee;
    }

    public void deductFee() {
        BigDecimal bd = this.getBalance();
        bd = bd.subtract(this.fee);
        this.setBalance(bd);
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
