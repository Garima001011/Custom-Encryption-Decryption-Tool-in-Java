
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    public static String readFile(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void writeFile(String path, String data) throws Exception {
        Files.write(Paths.get(path), data.getBytes());
    }
}
