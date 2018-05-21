package application.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsersProducts implements Serializable{
    @Expose
    private int countUsers;
    @Expose
    private Set<User3Dto> users;

    public UsersProducts() {
        this.users = new HashSet<>();
    }

    public int getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(int countUsers) {
        this.countUsers = countUsers;
    }

    public Set<User3Dto> getUsers() {
        return users;
    }

    public void setUsers(Set<User3Dto> users) {
        this.users = users;
    }
}
