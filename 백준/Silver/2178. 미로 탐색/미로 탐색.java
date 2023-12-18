import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[][] board;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] py = {0, 1, 0, -1};
    static int[] px = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++)
                board[i][j] = str.charAt(j) - '0';
        }
        q.offer(new Node(0, 0));
        
        int answer = BFS(N, M);

        System.out.println(answer);
        br.close();
    }
    public static int BFS(int N, int M) {
        int level = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node n = q.poll();

                if (n.y == N - 1 && n.x == M - 1)
                    return level;

                for (int j = 0; j < 4; j++) {
                    int nextY = n.y + py[j];
                    int nextX = n.x + px[j];

                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && board[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.offer(new Node(nextY, nextX));
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
