package application.models;

import application.annotations.description.Description;
import application.annotations.price.Price;
import application.annotations.title.Title;
import application.annotations.url.Url;
import application.annotations.video.Video;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Title
    private String title;
    @Video
    private String trailerVideoId;
    @Url
    private String url;
    @Price(digitsAfterDecPlate = 1)
    @Digits(integer = 18, fraction = 1)
    private BigDecimal size;
    @Price(message = "Invalid size format.")
    private BigDecimal price;
    @Description
    private String description;
    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToMany
    @JoinTable(name = "games_users",
                joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> owners;

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerVideoId() {
        return trailerVideoId;
    }

    public void setTrailerVideoId(String trailerVideoId) {
        this.trailerVideoId = trailerVideoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }
}
