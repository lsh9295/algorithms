package dfs_bfs_활용;

import java.util.*;
import java.io.*;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static Queue<Node> queue = new LinkedList<>();
    static int[][] board = new int[7][7];
    static int[][] visited = new int[7][7];
    static int answer = 0;
    static int[] py = {0, 0, 1, -1}; // 동, 서, 남, 북
    static int[] px = {1,-1, 0,  0};

    static boolean isEnd;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 7; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        queue.offer(new Node(0,0));
        BFS();
        if (isEnd)
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node n = queue.poll();

                if (n.y == 6 && n.x == 6) {
                    isEnd = true;
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int ny = n.y + py[j];
                    int nx = n.x + px[j];

                    if (ny >= 0 && ny <= 6 && nx >= 0 && nx <= 6 && board[ny][nx] == 0) {
                        if (visited[ny][nx] == 0) {
                            queue.offer(new Node(ny, nx));
                            visited[ny][nx] = 1;
                        }
                    }
                }
            }
            answer++;
        }
    }
}