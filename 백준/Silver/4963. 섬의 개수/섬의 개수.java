import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int w = -1;
    static int h = -1;
    static int answer = 0;
    static int[] px = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] py = {-1, -1, -1, 0, 1, 1, 1, 0};
    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;
            else
                board = new int[h][w];

            for (int i = 0; i < h; i++) { // 섬과 바다 배열 초기화
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1) {
                        answer++;
                        DFS(i, j);
                    }
                }
            }
            answerList.add(answer);
            answer = 0;
        }

        for (int x : answerList) {
            System.out.println(x);
        }
    }

    public static void DFS(int nh, int nw) { // DFS 섬 탐색 프로세스 (6방향)
        if ((nh <= -1 || nh >= h) || (nw <= -1 || nw >= w))
            return;

        if (board[nh][nw] == 1) {
            board[nh][nw] = 0;
        }
        else
            return;

        for (int i = 0; i < 8; i++) {
            DFS(nh + py[i], nw + px[i]);
        }
    }
}