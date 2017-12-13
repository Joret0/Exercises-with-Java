package logger.classes;

import logger.interfaces.File;

public class LogFile implements File{
    private StringBuilder builder = new StringBuilder();

    @Override
    public void write(String formattedMessage) {
        this.builder.append(formattedMessage);
    }

    @Override
    public long getSize() {
        long asciiSum = 0;
        for (char c : this.builder.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                asciiSum += c;
            }
        }
        return asciiSum;
    }
}
