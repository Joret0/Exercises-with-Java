package Pr5OnlineRadioDatabase.models;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private List<Song> songs;
    private int playListHours;
    private int playListMinutes;
    private int playListSeconds;

    public PlayList() {
        this.songs = new ArrayList<>();
    }

    public void calculatePlayListLength() {
        int totalSeconds = 0;
        for (Song song : this.songs) {
            totalSeconds += song.getSongSeconds();
            totalSeconds += song.getSongMinutes() * 60;
        }
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds / 60) % 60;
        int seconds = totalSeconds % 60;

        this.playListHours = hours;
        this.playListMinutes = minutes;
        this.playListSeconds = seconds;
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Song added.");
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d%nPlaylist length: %dh %dm %ds",
                this.songs.size(), this.playListHours, this.playListMinutes, this.playListSeconds);
    }
}
