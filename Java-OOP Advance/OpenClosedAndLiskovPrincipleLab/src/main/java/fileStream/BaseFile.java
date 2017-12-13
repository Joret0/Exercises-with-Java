package fileStream;

public abstract class BaseFile {
    private int length;
    private int bytesSent;

    public BaseFile(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return this.length;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }
}
