import java.util.*;
import java.io.*;

class Node {
    int n;
    int m;

    public Node(int n, int m) {
        this.n = n;
        this.m = m;
    }
}
public class Main {
    static Queue<Node> Q = new LinkedList<>();
    static int N, M;
    static int[] pn= { -1,-1, 0, 1, 1,  1, 0, -1};
    static int[] pm= {  0, 1, 1, 1, 0, -1,-1, -1};
    static int[][] board;
    static int[][] visited;
    static int answer = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) { // board 초기화
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 1) {
                    Q.offer(new Node(i, j));
                    visited[i][j] = 1;
                    BFS();
                    visited = new int[N][M];
                    Q.clear();
                }
            }
        }
        System.out.print(answer);
    }

    public static void BFS() {
        int dist = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Node n = Q.poll();
                if (board[n.n][n.m] == 1) {
                    answer = Math.max(dist, answer);

                    return;
                }
                for (int j = 0; j < 8; j++) {
                    if ((n.n + pn[j] >= 0 && n.n + pn[j] < N) && (n.m + pm[j] >= 0 && n.m + pm[j] < M)) {
                        if (visited[n.n + pn[j]][n.m + pm[j]] == 0) {
                            Q.offer(new Node(n.n + pn[j], n.m + pm[j]));
                            visited[n.n + pn[j]][n.m + pm[j]] = 1;
                        }
                    }
                }
            }
            dist++;
        }
    }
}