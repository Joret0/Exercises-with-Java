package Pr5OnlineRadioDatabase.models;

import Pr5OnlineRadioDatabase.exceptions.InvalidArtistNameException;
import Pr5OnlineRadioDatabase.exceptions.InvalidSongMinutesException;
import Pr5OnlineRadioDatabase.exceptions.InvalidSongNameException;
import Pr5OnlineRadioDatabase.exceptions.InvalidSongSecondsException;

public class Song {

    private String artistName;
    private String songName;
    private int songMinutes;
    private int songSeconds;

    public Song(String artistName, String songName, int songMinutes, int songSeconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongMinutes(songMinutes);
        this.setSongSeconds(songSeconds);
    }

    public String getArtistName() {
        return this.artistName;
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    int getSongMinutes() {
        return this.songMinutes;
    }

    private void setSongMinutes(int songMinutes) {
        if (songMinutes < 0 || songMinutes > 14) {
            throw new InvalidSongMinutesException();
        }
        this.songMinutes = songMinutes;
    }

    int getSongSeconds() {
        return this.songSeconds;
    }

    private void setSongSeconds(int songSeconds) {
        if (songSeconds < 0 || songSeconds > 59) {
            throw new InvalidSongSecondsException();
        }
        this.songSeconds = songSeconds;
    }
}
