import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] words = s.split(" ");
        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > max) {
                max = words[i].length();
                maxIdx = i;
            }
        }
        System.out.println(words[maxIdx]);
    }
}