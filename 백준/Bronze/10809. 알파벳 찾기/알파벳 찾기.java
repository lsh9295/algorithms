import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        foundAlpha(input);
    }

    private static void foundAlpha(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < s.length(); i++) {
            char ascii = s.charAt(i);
            if (arr[ascii - 97] == -1)
                arr[ascii - 97] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + " ");
        }
    }
}
