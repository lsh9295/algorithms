import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        String words = br.readLine();
        System.out.println(countWords(words));
    }

    private static int countWords(String words) {
        int cnt = 0;
        String trimWords = words.trim();
        String[] subWords = trimWords.split(" ");
        cnt = subWords.length;

        if (subWords[0].isEmpty() == true)
            return 0;
        else
            return cnt;
    }
}