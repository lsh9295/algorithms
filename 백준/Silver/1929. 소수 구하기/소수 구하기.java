import java.io.*;
import java.util.*;

/**
 * Baekjoon 1929 소수 구하기
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[max + 1]; // true면 소수

        Arrays.fill(isPrime, true); // 일단 전부 true로 초기화
        isPrime[0] = isPrime[1] = false; // 0이랑 1은 무조건 소수가 아님

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i)
                    isPrime[j] = false;
            }
        }
        for (int i = min; i <= max; i++) {
            if (isPrime[i])
                System.out.println(i);
        }
    }
}