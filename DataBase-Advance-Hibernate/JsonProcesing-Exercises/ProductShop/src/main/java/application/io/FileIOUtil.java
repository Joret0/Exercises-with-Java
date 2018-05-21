package application.io;

import java.io.*;

public class FileIOUtil {

    public String read(String filePath) throws IOException {
        InputStream stream = getClass().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    public void write(String content, String filePath) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));){
            writer.write(content);
        }
    }
}
