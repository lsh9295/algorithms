import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int K = Integer.parseInt(st.nextToken()); // 목표 최단 거리
        int X = Integer.parseInt(st.nextToken()); // 시작 노드

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, 1));
        }
        dijkstra(graph, dist, X);
        
        boolean check = true;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                check = false;
            }
        }
        if (check)
            System.out.println(-1);
            
    }
    static void dijkstra(ArrayList<Node>[] arr, int[] dist, int start) {
        boolean[] visited = new boolean[dist.length + 1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;

        q.add(new Node(start, 0));
        Arrays.fill(visited, false); //방문여부 체크 배열 false로 초기화

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.node])
                continue;
            visited[now.node] = true;

            for (Node next : arr[now.node]) {
                if (dist[next.node] > dist[now.node] + 1) {
                    dist[next.node] = dist[now.node] + 1;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
