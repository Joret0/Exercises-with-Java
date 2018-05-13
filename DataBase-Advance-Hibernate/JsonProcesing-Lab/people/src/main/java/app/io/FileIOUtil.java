package app.io;

import java.io.*;

public class FileIOUtil {

    public String read(String fileName) throws IOException {
        InputStream stream = getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    public void write(String content, String fileName) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(fileName);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));) {
            writer.write(content);
        }
    }
}
