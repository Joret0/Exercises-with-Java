package logger.interfaces;

public interface File {
    void write(String formattedMessage);
    long getSize();
}
