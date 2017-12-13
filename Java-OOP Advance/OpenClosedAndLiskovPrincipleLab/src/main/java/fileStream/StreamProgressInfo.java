package fileStream;

public class StreamProgressInfo {
    private BaseFile file;

    public StreamProgressInfo(BaseFile file) {
        this.file = file;
    }

    public int calculateCurrentPercent() {
        return (this.file.getBytesSent() * 100) / this.file.getLength();
    }
}
