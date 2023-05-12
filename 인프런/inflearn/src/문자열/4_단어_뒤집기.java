import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        String[] reverseWords = new String[N];

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            words[i] = br.readLine();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                char c = words[i].charAt(j);
                sb.append(c);
            }
            reverseWords[i] = sb.toString();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(reverseWords[i]);
        }
    }
}