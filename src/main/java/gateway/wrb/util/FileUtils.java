package gateway.wrb.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public List<String> getFilesDirectory(String directoryPath) {
        List<String> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(directoryPath))) {
            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
