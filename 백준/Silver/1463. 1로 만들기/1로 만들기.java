import java.io.*;
import java.util.*;

/**
 * Baekjoon 1463 1로 만들기
 */
class Main {
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 6 == 0)
                dp[i] = Math.min(Math.min(dp[i / 3] + 1, dp[i / 2] + 1), dp[i]);
            else if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            else if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }
        System.out.println(dp[N]);
    }
}
// DP Bottom-Up

