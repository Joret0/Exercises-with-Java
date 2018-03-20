package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "game")
@Inheritance(strategy = InheritanceType.JOINED)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "id")
    private Team homeTeam;
    @OneToOne
    @JoinColumn(name = "guest_team_id", referencedColumnName = "id")
    private Team guestTeam;
    @Column(name = "home_goals")
    private int homeGoals;
    @Column(name = "guest_goals")
    private int guestGoals;
    @Column(name = "time_of_game")
    private LocalDate timeOfGame;
    @Column(name = "home_win_rate")
    private BigDecimal homeWinRate;
    @Column(name = "guest_win_rate")
    private BigDecimal guestWinRate;
    @Column(name = "draw_win_rate")
    private BigDecimal drawWinRate;
    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;
    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;
    @ManyToMany(mappedBy = "games")
    private Set<Player> players;

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    public void setGuestGoals(int guestGoals) {
        this.guestGoals = guestGoals;
    }

    public LocalDate getTimeOfGame() {
        return timeOfGame;
    }

    public void setTimeOfGame(LocalDate timeOfGame) {
        this.timeOfGame = timeOfGame;
    }

    public BigDecimal getHomeWinRate() {
        return homeWinRate;
    }

    public void setHomeWinRate(BigDecimal homeWinRate) {
        this.homeWinRate = homeWinRate;
    }

    public BigDecimal getGuestWinRate() {
        return guestWinRate;
    }

    public void setGuestWinRate(BigDecimal guestWinRate) {
        this.guestWinRate = guestWinRate;
    }

    public BigDecimal getDrawWinRate() {
        return drawWinRate;
    }

    public void setDrawWinRate(BigDecimal drawWinRate) {
        this.drawWinRate = drawWinRate;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
