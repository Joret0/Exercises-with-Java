package Pr5OnlineRadioDatabase;

import Pr5OnlineRadioDatabase.exceptions.InvalidSongException;
import Pr5OnlineRadioDatabase.models.PlayList;
import Pr5OnlineRadioDatabase.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayList playList = new PlayList();
        int numberOfSongsToAdd = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfSongsToAdd; i++) {
            String[] input = reader.readLine().split(";");
            if (input.length < 3) {
                throw new InvalidSongException();
            }
            String artist = input[0];
            String songName = input[1];
            String totalTime = input[2];
            try {
                int indexOfSeparator = totalTime.indexOf(":");
                int minutes = Integer.parseInt(totalTime.substring(0, indexOfSeparator));
                int seconds = Integer.parseInt(totalTime.substring(indexOfSeparator + 1));
                Song song = new Song(artist, songName, minutes, seconds);
                playList.addSong(song);
            } catch (InvalidSongException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid song length.");
            }
        }
        playList.calculatePlayListLength();
        System.out.println(playList);
    }
}
