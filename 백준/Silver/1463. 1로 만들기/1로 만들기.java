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

        System.out.println(recursive(N));
    }

    static int recursive(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(Math.min(recursive(N / 3), recursive(N / 2)), recursive(N - 1)) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(recursive(N / 3), recursive(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(recursive(N / 2), recursive(N - 1)) + 1;
            } else {
                dp[N] = recursive(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
// DP Top-Down 방식

