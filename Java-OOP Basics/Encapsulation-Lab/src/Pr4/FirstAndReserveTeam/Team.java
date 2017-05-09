package Pr4.FirstAndReserveTeam;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeamPlayers;
    private List<Person> reverseTeamPlayers;

    public Team(String name) {
        this.setName(name);
        this.firstTeamPlayers = new ArrayList<>();
        this.reverseTeamPlayers = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }
    public List<Person> getFirstTeamPlayers() {
        return Collections.unmodifiableList(this.firstTeamPlayers);
    }
    private void setFirstTeamPlayers(List<Person> firstTeamPlayers) {
        this.firstTeamPlayers = firstTeamPlayers;
    }

    public List<Person> getReverseTeamPlayers() {
        return Collections.unmodifiableList(this.reverseTeamPlayers);
    }
    private void setReverseTeamPlayers(List<Person> reverseTeamPlayers) {
        this.reverseTeamPlayers = reverseTeamPlayers;
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            firstTeamPlayers.add(person);
        } else {
            reverseTeamPlayers.add(person);
        }
    }
}
