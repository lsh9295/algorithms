import java.io.*;
import java.util.*;

/**
 * Baekjoon 1260 DFS와 BFS
 */
class Main {
    static int N;
    static int M;
    static int startN;
    static int[][] graph;
    static boolean[] visited;
    static int[] answer;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startN = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A][B] = graph[B][A] = 1; // 간선이 존재하면 1
        }
        DFS(startN);

        Arrays.fill(visited, false);
        Arrays.fill(answer, 0);
        System.out.println();

        BFS();
    }
    
    static void DFS(int nowN) {
        visited[nowN] = true;
        System.out.print(nowN + " ");

        for (int i = 0; i < N + 1; i++) {
            if (graph[nowN][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS() {
        queue.offer(startN);
        System.out.print(startN + " ");
        visited[startN] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i < N + 1; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    System.out.print(i + " ");
                    visited[i] = true;
                }
            }
        }
    }
}

