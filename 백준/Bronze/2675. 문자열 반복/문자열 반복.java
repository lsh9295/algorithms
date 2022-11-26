import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < tCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 스트링 토크나이저

            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            stringRepeat(num, str);
        }
    }

    private static void stringRepeat(int num, String str) {
        StringBuilder sb = new StringBuilder(); // 스트링 빌더

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < num; j++) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
