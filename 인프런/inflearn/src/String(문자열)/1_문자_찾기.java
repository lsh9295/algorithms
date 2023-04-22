import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = br.readLine().charAt(0);
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c || s.charAt(i) == c - 32 || s.charAt(i) == c + 32)
                cnt++;
        }
        System.out.println(cnt);
    }
}