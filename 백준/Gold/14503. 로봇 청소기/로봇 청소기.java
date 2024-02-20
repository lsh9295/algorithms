import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static int[][] board;
    static Queue<Node> q = new LinkedList<>();
    static int dir;
    static int[] dy = {-1, 0, 1, 0}; // 0123 -> 북동남서
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());;
        int startX = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) { // 보드 초기화
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.offer(new Node(startY, startX));

        BFS();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2)
                    answer++;
            }
        }
        System.out.println(answer);
    }
    
    public static void BFS() {
        while (!q.isEmpty()) {
            boolean isClean = true; // true -> 4방향이 2인(청소) 경우
            
            Node node = q.poll();
            int ny = node.y;
            int nx = node.x;

            board[ny][nx] = 2; // 청소 처리

            for (int i = 0; i < 4; i++) { // 주변 청소 탐색
                if (board[ny + dy[i]][nx + dx[i]] == 0)  {
                    isClean = false;
                }
            }
            if (isClean) {
                int backDir = (dir - 2 + 4) % 4;
                int backY = ny + dy[backDir];
                int backX = nx + dx[backDir];

                if (board[backY][backX] == 1) {
                    return;
                } else {
                    q.offer(new Node(backY, backX)); // 한 칸 후진
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    dir = (dir - 1 + 4) % 4;
                    int moveY = ny + dy[dir];
                    int moveX = nx + dx[dir];

                    if (board[moveY][moveX] == 0) {
                        q.offer(new Node(moveY, moveX)); // 한 칸 전진
                        break;
                    }
                }
            }
        }
    }
}