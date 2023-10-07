import java.util.*;
import java.io.*;

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static Queue<Node> Q = new LinkedList<>();
    static int answer = 0;
    static int isSuccess = 0;
    static int[][] board = new int[5][5];
    static int[][] visited = new int[5][5];
    static int[] pr = {-1, 0, 1, 0};
    static int[] pc = {0, 1, 0, -1};
    static int r;
    static int c;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) { // board 초기화
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Q.add(new Node(r, c));

        BFS();
        
        if (isSuccess == 0)
            System.out.println(-1);
    }

    public static void BFS() {
        while(!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Node n = Q.poll();

                if (board[n.r][n.c] == 1) {
                    System.out.println(answer);
                    isSuccess = 1;
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    if ((n.r + pr[j] >= 0 && n.r + pr[j] <= 4) && (n.c + pc[j] >= 0 && n.c + pc[j] <= 4)) {
                        if (visited[n.r + pr[j]][n.c + pc[j]] == 0 && board[n.r + pr[j]][n.c + pc[j]] != -1) {
                            Q.offer(new Node(n.r + pr[j], n.c + pc[j]));
                            visited[n.r + pr[j]][n.c + pc[j]] = 1; // 방문처리
                        }
                    }
                }
            }
            answer++;
        }
    }
}