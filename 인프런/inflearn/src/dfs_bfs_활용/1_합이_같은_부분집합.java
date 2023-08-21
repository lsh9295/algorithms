package dfs_bfs_활용;

import java.io.*;
import java.util.*;

public class Main {
    static String answer = "NO";
    static boolean flag = false;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] set = new int[n];

        // 집합 초기화
        for (int i = 0; i < n; i++) {
            set[i] = Integer.parseInt(st.nextToken());
            total += set[i];
        }

        DFS(0,0, set);

        System.out.println(answer);
    }

    public static void DFS(int L, int sum, int[] set) {
        if (flag)
            return;

        if (sum > total / 2)
            return;

        if (L != set.length) {
            if ((total - sum) == sum) {
                flag = true;
                answer = "YES";
            } else {
                DFS(L + 1, sum + set[L], set);
                DFS(L + 1, sum, set);
            }
        }
    }
}