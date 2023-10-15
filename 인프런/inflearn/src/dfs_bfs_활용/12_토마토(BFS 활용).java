package dfs_bfs_활용;

import java.util.*;
import java.io.*;

/**
 * 익지 않은 토마트 인접 왼쪽, 오른쪽, 앞 뒤 네 방향에 익은 토마토가 있으면 토마토가 익어버림
 * 며칠이 지나면 토마토가 모두 익는지 카운팅
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 */

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int answer = -1;
    static int M;
    static int N;
    static int[] py = {0 ,0 ,1 ,-1};
    static int[] px = {-1 ,1 ,0 ,0};
    static int[][] board;
    static Queue<Node> q = new LinkedList<>();
    static boolean ignore = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) { // 토마토 상자 초기화
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 0 && !ignore) // 하나라도 덜 익었니?
                    ignore = true;

                if (board[i][j] == 1) // 익은 토마토를 Queue에 추가
                    q.offer(new Node(i, j));
            }
        }
        if (!ignore) // 처음부터 토마토가 다 익어있는 경우
            System.out.println(0);

        BFS();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);

                    return;
                }
            }
        }
        System.out.println(answer);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node n = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = n.y + py[j];
                    int nx = n.x + px[j];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && board[ny][nx] == 0) {
                        q.offer(new Node(ny, nx));
                        board[ny][nx] = 1;
                    }
                }
            }
            answer++;
        }
    }
}
