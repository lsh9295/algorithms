import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 665;
        while (input != cnt) {
            num++;
            if (String.valueOf(num).contains("666"))
                cnt++;
        }
        System.out.println(num);
    }
}