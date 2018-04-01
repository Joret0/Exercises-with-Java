package application;

import application.models.Album;
import application.models.Picture;
import application.models.Town;
import application.models.User;
import application.services.album.AlbumService;
import application.services.album.AlbumServiceImpl;
import application.services.picture.PictureService;
import application.services.picture.PictureServiceImpl;
import application.services.town.TownService;
import application.services.town.TownServiceImpl;
import application.services.user.UserService;
import application.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootConfiguration
@Component
public class ConsoleRunner implements CommandLineRunner{
    private AlbumServiceImpl albumService;
    private PictureServiceImpl pictureService;
    private TownServiceImpl townService;
    private UserServiceImpl userService;

    @Autowired
    public ConsoleRunner(AlbumServiceImpl albumService, PictureServiceImpl pictureService, TownServiceImpl townService, UserServiceImpl userService) {
        this.albumService = albumService;
        this.pictureService = pictureService;
        this.townService = townService;
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Town> towns = seedTowns();
        seedUsers(towns);
        seedPictureAndAlbumsAndFriends();
    }

    private void seedPictureAndAlbumsAndFriends() {
        List<User> allUsers = this.userService.findAll();

        User georgi = allUsers.get(0);
        Album album = new Album();
        album.setName("Cristmas Party");
        album.setColor("Colored");
        album.setOwner(georgi);

        Picture picture = new Picture();
        picture.setCaption("caption");
        picture.setPath("PathFile");
        picture.setTitle("Christmas");
        picture.setAlbums(new HashSet<Album>() {{
            add(album);
        }});

        album.setPictures(new HashSet<Picture>() {{
            add(picture);
        }});

        georgi.setFriends(new HashSet<User>() {{
            add(allUsers.get(1));
            add(allUsers.get(2));
        }});

        this.pictureService.save(picture);
        this.albumService.save(album);
        this.userService.save(georgi);

        User ivan = allUsers.get(1);
        Album album2 = new Album();
        album2.setName("Cristmas Party");
        album2.setColor("Colored");
        album2.setOwner(ivan);

        Picture picture2 = new Picture();
        picture2.setCaption("caption");
        picture2.setPath("PathFile");
        picture2.setTitle("Christmas");
        picture2.setAlbums(new HashSet<Album>() {{
            add(album2);
        }});

        album2.setPictures(new HashSet<Picture>() {{
            add(picture2);
        }});

        ivan.setFriends(new HashSet<User>() {{
            add(allUsers.get(0));
            add(allUsers.get(2));
        }});

        this.pictureService.save(picture2);
        this.albumService.save(album2);
        this.userService.save(ivan);

        User aneta = allUsers.get(2);
        Album album3 = new Album();
        album3.setName("Cristmas Party");
        album3.setColor("Colored");
        album3.setOwner(aneta);

        Picture picture3 = new Picture();
        picture3.setCaption("caption");
        picture3.setPath("PathFile");
        picture3.setTitle("Christmas");
        picture3.setAlbums(new HashSet<Album>() {{
            add(album3);
        }});

        album3.setPictures(new HashSet<Picture>() {{
            add(picture3);
        }});

        aneta.setFriends(new HashSet<User>() {{
            add(allUsers.get(0));
            add(allUsers.get(1));
        }});

        this.pictureService.save(picture3);
        this.albumService.save(album3);
        this.userService.save(aneta);
    }

    private List<Town> seedTowns() {
        List<Town> towns = new ArrayList<>();

        Town haskovo = new Town();
        haskovo.setName("Haskovo");
        haskovo.setCountry("Bulgaria");
        this.townService.save(haskovo);

        Town sofia = new Town();
        sofia.setName("Sofia");
        sofia.setCountry("Bulgaria");
        this.townService.save(sofia);

        Town plovdiv = new Town();
        plovdiv.setName("Plovdiv");
        plovdiv.setCountry("Bulgaria");
        this.townService.save(plovdiv);

        Town varna = new Town();
        varna.setName("Varna");
        varna.setCountry("Bulgaria");
        this.townService.save(varna);

        Town burgas = new Town();
        burgas.setName("Burgas");
        burgas.setCountry("Bulgaria");
        this.townService.save(burgas);

        towns.add(haskovo);
        towns.add(sofia);
        towns.add(plovdiv);
        towns.add(varna);
        towns.add(burgas);

        return towns;
    }

    private void seedUsers(List<Town> towns) throws ParseException {

        User georgi = new User();
        georgi.setUsername("Joret0");
        georgi.setAge(34);
        Town bornTown = towns.get(0);
        georgi.setBornTown(bornTown);
        georgi.setDeleted(false);
        georgi.setEmail("georgi_stalev@abv.bg");
        georgi.setFirstName("Georgi");
        georgi.setLastName("Stalev");
        georgi.setFullName("Georgi Ivanov Stalev");
        Town livingTown = towns.get(1);
        georgi.setLivingTown(livingTown);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-8-2017 10:20:56";
        Date date = sdf.parse(dateInString);
        georgi.setLastTimeLoggedIn(date);
        georgi.setPassword("@Aaabbb1234#");
        dateInString = "30-3-2018 11:25:00";
        date = sdf.parse(dateInString);
        georgi.setRegisteredOn(date);
        georgi.setProfilePicture(new byte[5]);

        this.userService.save(georgi);

        User ivan = new User();
        ivan.setUsername("IvanSpring");
        ivan.setAge(55);
        bornTown = towns.get(0);
        ivan.setBornTown(bornTown);
        ivan.setDeleted(false);
        ivan.setEmail("ivan_stalev@abv.bg");
        ivan.setFirstName("Ivan");
        ivan.setLastName("Stalev");
        ivan.setFullName("Ivan Georgiev Stalev");
        livingTown = towns.get(1);
        ivan.setLivingTown(livingTown);
        dateInString = "21-7-2017 09:20:56";
        date = sdf.parse(dateInString);
        ivan.setLastTimeLoggedIn(date);
        ivan.setPassword("@Aaabbb1234#");
        dateInString = "18-2-2018 15:25:00";
        date = sdf.parse(dateInString);
        ivan.setRegisteredOn(date);
        ivan.setProfilePicture(new byte[5]);

        this.userService.save(ivan);

        User aneta = new User();
        aneta.setUsername("Aneta");
        aneta.setAge(53);
        bornTown = towns.get(0);
        aneta.setBornTown(bornTown);
        aneta.setDeleted(false);
        aneta.setEmail("aneta_moleva@abv.bg");
        aneta.setFirstName("Aneta");
        aneta.setLastName("Moleva");
        aneta.setFullName("Aneta Moleva");
        livingTown = towns.get(1);
        aneta.setLivingTown(livingTown);
        dateInString = "26-9-2017 17:22:56";
        date = sdf.parse(dateInString);
        aneta.setLastTimeLoggedIn(date);
        aneta.setPassword("@Aaabbb1234#");
        dateInString = "18-2-2018 15:25:00";
        date = sdf.parse(dateInString);
        aneta.setRegisteredOn(date);
        aneta.setProfilePicture(new byte[5]);

        this.userService.save(aneta);
    }
}
