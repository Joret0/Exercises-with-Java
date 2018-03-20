package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "bet")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bet_money")
    private BigDecimal betMoney;
    @Column(name = "time_of_bet")
    private LocalDate timeOfBet;
    @OneToMany(mappedBy = "bet")
    private Set<BetGame> betGames;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Bet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDate getTimeOfBet() {
        return timeOfBet;
    }

    public void setTimeOfBet(LocalDate timeOfBet) {
        this.timeOfBet = timeOfBet;
    }

    public Set<BetGame> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGame> betGames) {
        this.betGames = betGames;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
