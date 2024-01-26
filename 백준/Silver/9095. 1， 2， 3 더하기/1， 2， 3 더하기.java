import java.io.*;
import java.util.*;

/**
 * Baekjoon 9095 1, 2, 3 더하기
 */
class Main {
    static int count;
    static int num;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            num = Integer.parseInt(br.readLine());
            
            DFS(0);
            System.out.println(count);
        }
    }

    public static void DFS(int sum) {
        if (sum == num) {
            count++;
            return;
        }
        if (sum > num) {
            return;
        }
        DFS(sum + 1);
        DFS(sum + 2);
        DFS(sum + 3);
    }
}
