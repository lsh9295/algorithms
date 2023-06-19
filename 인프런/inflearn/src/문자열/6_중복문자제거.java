import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] cList = str.toCharArray();
        ArrayList<Character> selected= new ArrayList<Character>();

        for (char c : cList)
            if (!(selected.contains(c)))
                selected.add(c);

        for (Character c : selected)
            System.out.print(c);
    }
}