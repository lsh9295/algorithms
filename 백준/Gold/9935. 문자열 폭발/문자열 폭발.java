import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() >= bomb.length()) {
                if (sb.substring(sb.length() - bomb.length(), sb.length()).equals(bomb)) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        if (sb.toString().equals("")) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}