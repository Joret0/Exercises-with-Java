package application.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class JSONParser {
    private Gson gson;
    private FileIOUtil fileIOUtil;

    public JSONParser() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.fileIOUtil = new FileIOUtil();
    }

    public<T> T importJson(Class<T> tClass, String fileName) throws IOException {
        String content = this.fileIOUtil.read(fileName);
        T mapped = this.gson.fromJson(content, tClass);
        return mapped;
    }

    public<T> void outputJson(T dto, String fileName) throws IOException {
        String content = this.gson.toJson(dto);
        this.fileIOUtil.write(content, fileName);
    }
}
