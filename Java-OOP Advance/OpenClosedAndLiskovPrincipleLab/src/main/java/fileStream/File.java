package fileStream;

public class File extends BaseFile{

    private String name;

    public File(String name, int length, int bytesSent) {
        super(length, bytesSent);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
