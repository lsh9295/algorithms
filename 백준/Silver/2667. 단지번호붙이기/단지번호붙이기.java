import java.io.*;
import java.util.*;

/**
 * Baekjoon 2667 단지번호붙이기
 */
class Main {
    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    BFS();
                }
            }
        }
        System.out.println(pq.size());
        
        while (!pq.isEmpty())
            System.out.println(pq.poll());
    }
    
    static void BFS() {
        int cnt = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (board[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.offer(new Node(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        pq.offer(cnt);
    }
}