import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int i = N - 1;
        while (K != 0) {
            if (coin[i] > K) {
                i -= 1;
                continue;
            }
            cnt += (K / coin[i]);
            K %= coin[i];
        }
        System.out.println(cnt);
    }
}