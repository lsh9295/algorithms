package dfs_bfs_활용;

import java.util.*;
import java.io.*;

public class Main {
    static int[] PM;
    static int N, M;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PM = new int[M];

        DFS(0);
    }

    public static void DFS(int L) {
        if (L == M) {
            for (int x : PM) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= N; i++) {
                PM[L] = i;
                DFS(L + 1);
            }
        }
    }
}