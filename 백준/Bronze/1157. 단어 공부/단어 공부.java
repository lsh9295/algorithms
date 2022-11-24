import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(mostUsed(input));
    }
    private static char mostUsed(String string) {
        int[] alphabet = new int[26];
        int max = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < string.length(); i++) {
            char word = string.charAt(i);

            if (word >= 'a' && word <= 'z')
                alphabet[word - 'a']++;
            else if (word >= 'A' && word <= 'Z')
                alphabet[word - 'A']++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (maxIdx == i)
                continue;
            if (alphabet[i] == max)
                return '?';
        }

        return (char)(maxIdx + 'A');
    }
}