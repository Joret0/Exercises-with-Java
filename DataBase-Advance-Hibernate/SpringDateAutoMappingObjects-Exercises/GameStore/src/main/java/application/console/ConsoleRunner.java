package application.console;

import application.dto.GameDetailsDto;
import application.dto.GameDto;
import application.models.Game;
import application.models.User;
import application.services.api.GameService;
import application.services.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner{

    private UserService<User, Long> userService;
    private GameService<Game, Long> gameService;
    private User loggedUser;

    @Autowired
    public ConsoleRunner(UserService<User, Long> userService, GameService<Game, Long> gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... strings) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine();
            String[] spl = line.split("\\|");
            if (line.equals("end")) {
                break;
            }
            switch (spl[0]) {
                case "RegisterUser":
                    doRegister(spl);
                    break;
                case "LoginUser":
                    doLogin(spl);
                    break;
                case "Logout":
                    if (this.loggedUser != null) {
                        doLogout();
                    } else {
                        System.out.println("You have to login!");
                    }
                    break;
                case "AddGame":
                    if (this.loggedUser != null) {
                        if (this.loggedUser.isAdmin()) {
                            addGame(spl);
                        } else {
                            System.out.printf("User %s is not admin.", this.loggedUser.getFullName());
                        }
                    } else {
                        System.out.println("Login first!");
                    }
                    break;
                case "EditGame":
                    if (this.loggedUser != null) {
                        if (this.loggedUser.isAdmin()) {
                            editGame(spl);
                        } else {
                            System.out.printf("User %s is not admin.%n", this.loggedUser.getFullName());
                        }
                    } else {
                        System.out.println("Login first!");
                    }
                    break;
                case "DeleteGame":
                    if (this.loggedUser != null) {
                        if (this.loggedUser.isAdmin()) {
                            deleteGame(spl);
                        } else {
                            System.out.printf("User %s is not admin.%n", this.loggedUser.getFullName());
                        }
                    } else {
                        System.out.println("Login first!");
                    }
                    break;
                case "AllGames":
                    printAllGames();
                    break;
                case "GameDetails":
                    printGameDetails(spl[1]);
                    break;
                case "OwnedGames":
                    if (this.loggedUser != null) {
                        printOwnedGames();
                    } else {
                        System.out.println("Login first!");
                    }
                    break;
                case "AddToShoppingCard":
                    if (this.loggedUser != null) {
                        addToCard(spl[1]);
                    } else {
                        System.out.println("Login first!");
                    }
                    break;
                case "RemoveFromShoppingCard":
                    if (this.loggedUser != null) {
                        removeFromCard(spl[1]);
                    } else {
                        System.out.println("Login first!");
                    }

                case "BuyGames":
                    if (this.loggedUser != null) {
                        buy();
                    } else {
                        System.out.println("Login first!");
                    }
            }
        }
    }

    private void buy() {
        for (Game game : this.loggedUser.getGames()) {
            this.gameService.save(game);
        }
    }

    private void removeFromCard(String title) {
        this.loggedUser.removeGame(title);
    }

    private void addToCard(String title) {
        Game game = this.gameService.findGameByTitle(title);
        if (game != null) {
            Set<Game> userGames = this.userService.getGameFromUser(title, this.loggedUser.getId());
            userGames = userGames.stream().filter(x -> x.getTitle().equals(game.getTitle())).collect(Collectors.toSet());
            Set<Game> loggedUserGames = this.loggedUser.getGames().stream().filter(x -> x.getTitle().equals(game.getTitle())).collect(Collectors.toSet());

            if (userGames.size() == 0 && loggedUserGames.size() == 0) {
                this.loggedUser.addGame(game);
                game.setOwners(new HashSet<User>() {{
                    add(loggedUser);
                }});
                System.out.printf("%s added to card.", title);
            } else {
                System.out.printf("%s already has game %s%n", loggedUser.getFullName(), title);
            }
        } else {
            System.out.printf("Game %s was not found.%n", title);
        }
    }

    private void printOwnedGames() {
        Set<User> userSet = new HashSet<User>() {{
            add(loggedUser);
        }};
        List<Game> games = this.gameService.findGameByOwners(userSet);
        ModelMapper modelMapper = new ModelMapper();
        GameDto dto;
        for (Game game : games) {
            dto = modelMapper.map(game, GameDto.class);
            System.out.printf("%s%n", dto.getTitle());
        }
    }

    private void printGameDetails(String title) {
        Game game = this.gameService.findGameByTitle(title);
        if (game != null) {
            ModelMapper modelMapper = new ModelMapper();
            GameDetailsDto dto = modelMapper.map(game, GameDetailsDto.class);
            System.out.printf("%s%n%.2f%n%.2f%n%s%n%s%n%s%n%s%n", dto.getTitle(), dto.getPrice(), dto.getSize(),
                    dto.getTrailer(), dto.getUrl(), dto.getDescription(), dto.getReleaseDate());
        } else {
            System.out.println("Game was not found.");
        }
    }

    private void printAllGames() {
        List<Game> allGames = this.gameService.findAll();
        ModelMapper modelMapper = new ModelMapper();
        GameDto gameDto;
        for (Game game : allGames) {
            gameDto = modelMapper.map(game, GameDto.class);
            System.out.printf("%s %.2f%n", gameDto.getTitle(), gameDto.getPrice());
        }
    }

    private void deleteGame(String[] spl) {
        Game game = this.gameService.findById(Long.valueOf(spl[1]));
        if (game != null) {
            this.gameService.remove(game);
            System.out.printf("Deleted %s.%n", game.getTitle());
        } else {
            System.out.println("Game not found.");
        }
    }

    private void editGame(String[] spl) throws ParseException {
        Game game = this.gameService.findById(Long.valueOf(spl[1]));
        if (game != null) {
            editGameDetails(spl, game);
            this.gameService.save(game);
            System.out.printf("Editted %s", game.getTitle());
        } else {
            System.out.println("Game not found.");
        }
    }

    private void editGameDetails(String[] spl, Game game) throws ParseException {
        for (int i = 2; i < spl.length; i++) {
            String s = spl[i];
            String[] propertyValue = s.split("=");

            switch (propertyValue[0]) {
                case "title":
                    game.setTitle(propertyValue[1]);
                    break;
                case "price":
                    game.setPrice(new BigDecimal(propertyValue[1]));
                    break;
                case "size":
                    game.setSize(new BigDecimal(propertyValue[1]));
                    break;
                case "trailer":
                    game.setTrailerVideoId(propertyValue[1]);
                    break;
                case "url":
                    game.setUrl(propertyValue[1]);
                    break;
                case "description":
                    game.setDescription(propertyValue[6]);
                    break;
                case "releasedate":
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.Mm.yyyy");
                    game.setReleaseDate(sdf.parse(propertyValue[7]));
                    break;
            }
        }
    }

    private void addGame(String[] spl) throws ParseException {
        String title = spl[1];
        BigDecimal price = BigDecimal.valueOf(Double.valueOf(spl[2]));
        BigDecimal size = BigDecimal.valueOf(Double.valueOf(spl[3]));
        String videoId = spl[4];
        String url = spl[5];
        String description = spl[6];
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(spl[7]);

        Game game = new Game();
        game.setPrice(price);
        game.setTitle(title);
        game.setSize(size);
        game.setTrailerVideoId(videoId);
        game.setUrl(url);
        game.setDescription(description);
        game.setReleaseDate(date);
        this.gameService.save(game);
        System.out.printf("Added %s%n", game.getTitle());
    }

    private void doLogout() {
        try {
            User user = this.userService.findById(this.loggedUser.getId());
            user.setLoggedIn(false);
            this.userService.save(user);
            System.out.printf("User %s successfully logged out.%n", user.getFullName());
        } catch (NullPointerException e) {
            System.out.println("Cannot log out. No one user was logged in.");
        }
    }

    private void doLogin(String[] spl) {
        String email = spl[1];
        String password = spl[2];
        loginUserIfExist(email, password);
    }

    private void loginUserIfExist(String email, String password) {
        User found = getLoggedUser(email, password);
        if (found != null) {
            found.setLoggedIn(true);
            this.userService.save(found);
            this.loggedUser = found;
            System.out.printf("Successfully logged in %s%n", found.getFullName());
        } else {
            System.out.println("Incorrect username / password");
        }
    }

    private User getLoggedUser(String email, String password) {
        return this.userService.findUserByEmailAndPassword(email, password);
    }

    private void doRegister(String[] spl) {
        String email = spl[1];
        String password = spl[2];
        String confirmPass = spl[3];
        String fullName = spl[4];

        if (password.equals(confirmPass)) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFullName(fullName);

            if (this.userService.findAll().size() == 0) {
                user.setAdmin(true);
            }

            this.userService.save(user);
            System.out.printf("%s was registered!%n", fullName);
        } else {
            System.out.println("Mismatch password");
        }
    }
}
