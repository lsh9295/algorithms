package dfs_bfs_활용;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[7][7];
    static int answer = 0;
    static int[] py = {0, 0, 1, -1}; // 동, 서, 남, 북
    static int[] px = {1,-1, 0,  0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 7; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        board[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int y, int x) {
        if (y == 6 && x == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + py[i];
                int nx = x + px[i];

                if ((ny >= 0 && ny <= 6) && (nx >= 0 && nx <= 6) && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    DFS(ny, nx);
                    board[ny][nx] = 0;
                }
            }
        }
    }
}