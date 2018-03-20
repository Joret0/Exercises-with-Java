package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
@Inheritance(strategy = InheritanceType.JOINED)
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "position_inicials", length = 3, unique = true, nullable = false)
    private String positionInicials;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @OneToMany(mappedBy = "position")
    private Set<Player> players;

    public Position() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionInicials() {
        return positionInicials;
    }

    public void setPositionInicials(String positionInicials) {
        this.positionInicials = positionInicials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
