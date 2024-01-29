import java.io.*;
import java.util.*;

/**
 * Baekjoon 1003 피보나치 함수
 */
class Main {
    static int[] countList = new int[40 + 1]; // 1의 출력 개수를 저장하는 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        countList[1] = 1;

        for (int i = 2; i <= 40; i++) {
            countList[i] = countList[i - 2] + countList[i - 1];
        }
        while (T > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                System.out.println(1 + " " + 0);
                T--;
                continue;
            }
            System.out.println(countList[num - 1] + " " + countList[num]);
            T--;
        }
    }
}