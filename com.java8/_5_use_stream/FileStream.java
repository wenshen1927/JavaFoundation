package _5_use_stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 从文件中获取流
 */
public class FileStream {
    public static void main(String[] args) {
        long uniqueWords = 0l;
        try (Stream<String> lines = Files.lines(Paths.get("/Users/zhangyanan/code/java_code/java_review/com.java8/_5_use_stream/words.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(uniqueWords);
    }
}
