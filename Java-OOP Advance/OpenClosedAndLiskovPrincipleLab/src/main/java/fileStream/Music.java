package fileStream;

public class Music extends BaseFile{
    private String artist;
    private String album;

    public Music(String artist, String album, int length, int bytesSent) {
        super(length, bytesSent);
        this.artist = artist;
        this.album = album;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getAlbum() {
        return this.album;
    }
}
