package dfs_bfs_기초;

import java.io.*;

public class Main {
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];
        reculsive(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public static int reculsive(int n) {
        if (fibo[n] != 0)
            return fibo[n];
        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        }
        else {
            return fibo[n] = reculsive(n - 2) + reculsive(n - 1);
        }
    }
}