package gateway.wrb.util;

import java.io.*;
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

    public void moveFile(String inputFile, String outputFile){
        InputStream inStream = null;
        OutputStream outStream = null;
        try{
            File afile =new File(inputFile);
            File bfile =new File(outputFile);
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);
            byte[] buffer = new byte[1024];
            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);

            }
            inStream.close();
            outStream.close();
            //delete the original file
            afile.delete();
            System.out.println("File is copied successful!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
