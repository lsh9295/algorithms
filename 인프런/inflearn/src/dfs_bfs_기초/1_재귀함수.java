package dfs_bfs_기초;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        reculsive(5);
    }

    public static void reculsive(int n) {
        if (n == 0) {
            return ;
        } else {
            reculsive(n - 1);
            System.out.print(n + " ");
        }
    }
}