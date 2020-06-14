package _2_behavior_paramlize;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {
    public static String processFile(BufferedReaderProcessor brp) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return brp.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String s = processFile((BufferedReader br) -> {
            return br.readLine() + br.readLine();
        });
        System.out.println(s);
    }



}
