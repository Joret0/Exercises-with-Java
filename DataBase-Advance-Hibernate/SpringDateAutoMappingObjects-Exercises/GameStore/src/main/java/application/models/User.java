package application.models;

import application.annotations.email.Email;
import application.annotations.password.Password;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(unique = true)
    private String email;
    @Password
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @ManyToMany(mappedBy = "owners", fetch = FetchType.EAGER)
    private Set<Game> games;
    @Column(name = "is_admin")
    private boolean isAdmin;

    private boolean isLoggedIn;

    public User() {
    }

    public User(String email, String password, String fullName, boolean isAdmin) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFullName(fullName);
        this.setAdmin(isAdmin);
        this.games = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public void removeGame(String title) {
        Iterator<Game> iter = this.games.iterator();

        while (iter.hasNext()) {
            String string = iter.next().getTitle();
            if (string.equals(title)) {
                iter.remove();
            }
        }
    }
}
