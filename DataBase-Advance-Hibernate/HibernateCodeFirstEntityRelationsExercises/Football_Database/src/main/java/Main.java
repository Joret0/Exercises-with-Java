import entities.*;
import enums.CompetitionTypes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("football_database");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        user.setFullName("Georgi Stalev");
        user.setBalance(new BigDecimal(1000.00));
        em.persist(user);

        Bet bet = new Bet();
        bet.setBetMoney(new BigDecimal(1000.00));
        bet.setTimeOfBet(LocalDate.now());
        bet.setUser(user);
        em.persist(bet);

        Color color = new Color();
        color.setName("green");
        Color color2 = new Color();
        color2.setName("red");
        em.persist(color);
        em.persist(color2);

        CompetitionType competitionType = new CompetitionType();
        competitionType.setName(CompetitionTypes.International.toString());
        em.persist(competitionType);

        Competition competition = new Competition();
        competition.setName("UCL");
        competition.setType(competitionType);
        em.persist(competition);

        Continent continent = new Continent();
        continent.setName("Europe");

        Country country = new Country();
        country.setName("Bulgaria");
        country.setInitials("BG");
        Set<Continent> continentSet = new HashSet<>();
        continentSet.add(continent);
        country.setContinents(continentSet);
        em.persist(country);

        Country country2 = new Country();
        country2.setName("Germany");
        country2.setInitials("GR");
        country2.setContinents(continentSet);
        em.persist(country2);

        Set<Country> countrySet = new HashSet<>();
        countrySet.add(country);
        countrySet.add(country2);
        continent.setCountries(countrySet);
        em.persist(continent);

        Town town = new Town();
        town.setName("Sofia");
        town.setCountry(country);
        em.persist(town);

        Town town2 = new Town();
        town2.setName("Berlin");
        town2.setCountry(country2);
        em.persist(town2);

        Round round = new Round();
        round.setName("Final");
        em.persist(round);

        ResultPrediction resultPrediction = new ResultPrediction();
        resultPrediction.setPrediction("3-1");
        em.persist(resultPrediction);

        Team team = new Team();
        team.setName("National Bulgarian Football Team");
        team.setPrimaryKitColor(color);
        team.setTown(town);
        em.persist(team);

        Team team2 = new Team();
        team2.setName("National Germany Football Team");
        team.setPrimaryKitColor(color2);
        team2.setTown(town2);
        em.persist(team2);

        Game game = new Game();
        game.setGuestTeam(team);
        game.setHomeTeam(team2);
        game.setCompetition(competition);
        game.setRound(round);

        Position position = new Position();
        position.setDescription("Defender");
        position.setPositionInicials("DF");
        em.persist(position);

        Player player = new Player();
        player.setPosition(position);
        player.setName("Georgi Stalev");
        player.setNumber(8);
        player.setTeam(team);
        Set<Game> games = new HashSet<>();
        games.add(game);
        player.setGames(games);
        em.persist(player);

        Set<Player> players = new HashSet<>();
        players.add(player);
        game.setPlayers(players);
        em.persist(game);

        PlayerStatistic playerStatistic = new PlayerStatistic();
        playerStatistic.setGame(game);
        playerStatistic.setGoals(2);
        playerStatistic.setAssists(1);
        playerStatistic.setMinutes(90);
        playerStatistic.setPlayer(player);
        em.persist(playerStatistic);

        BetGame betGame = new BetGame();
        betGame.setGame(game);
        betGame.setBet(bet);
        betGame.setResultPrediction(resultPrediction);
        em.persist(betGame);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
