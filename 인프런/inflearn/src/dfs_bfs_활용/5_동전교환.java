package dfs_bfs_활용;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] ch = new int[501];
    static int[] coins;
    static Queue<Integer> Q = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;

        while(st.hasMoreTokens()) {
            coins[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        M = Integer.parseInt(br.readLine());
        Q.offer(0);
        System.out.println(BFS(1));
    }

    public static int BFS(int L) {
        while(!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                int x = Q.poll();

                for (int j = 0; j < N; j++) {
                    int nx = x + coins[j];

                    if (ch[nx] == 0 && nx == M)
                        return L;
                    ch[nx] = 1;
                    Q.offer(nx);
                }
            }
            L++;
        }
        return -1;
    }
}