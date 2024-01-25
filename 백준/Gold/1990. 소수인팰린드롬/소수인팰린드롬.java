import java.io.*;
import java.util.*;

/**
 * Baekjoon 1990 소수인팰린드롬
 */
class Main {
    static boolean[] isPrime = new boolean[100000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Arrays.fill(isPrime, true);
        prime(b);

        for (int i = a; i <= b; i++)
            if (isPrime[i] && isPalindrome(i))
                System.out.println(i);

        System.out.print(-1);
    }

    static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        int start = 0;
        int end = str.length() - 1;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }

    public static void prime(int m) {
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (isPrime[i]) { // false면
                for (int j = i * i; j <= m; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
