import java.io.*;
import java.util.*;

/**
 * Baekjoon 2606 바이러스
 */
class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int computerCnt;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCnt = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        graph = new boolean[computerCnt + 1][computerCnt + 1];
        visited = new boolean[computerCnt + 1];
        StringTokenizer st;

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A][B] = graph[B][A] = true;
        }
        DFS(1);
        System.out.println(answer);
    }

    static void DFS(int nowNode) {
        visited[nowNode] = true;

        for (int i = 1; i <= computerCnt; i++) {
            if (!visited[i] && graph[nowNode][i]) {
                answer++;
                DFS(i);
            }
        }
    }
}
