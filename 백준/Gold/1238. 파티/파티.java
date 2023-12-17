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
    static ArrayList<Node>[] graph, r_graph;
    static int[] dist, r_dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        r_graph = new ArrayList[N + 1];

        dist = new int[N + 1];
        r_dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(r_dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            r_graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            r_graph[end].add(new Node(start, cost));
        }
        dijkstra(graph, dist, X);
        dijkstra(r_graph, r_dist, X); // 역방향 다익스트라

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i] + r_dist[i]);
        }
        System.out.println(max);

        br.close();
    }

    static void dijkstra(ArrayList<Node>[] arr, int[] dist, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[dist.length];

        q.add(new Node(start, 0));
        dist[start] = 0;
        Arrays.fill(visited, false); //방문여부 체크 배열 false로 초기화


        while(!q.isEmpty()) {
            Node now = q.poll();

            if(visited[now.node]) continue; //방문했던 정점이면 스킵
            visited[now.node] = true; //미방문이면 방문으로(true)로 셋팅하고 for문 처리

            for (Node next : arr[now.node]) {
                if (dist[next.node] > dist[now.node] + next.cost) {
                    dist[next.node] = dist[now.node] + next.cost;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
/*
1. X에서 출발해 다른 노드로 가는 최단경로를 모두 구한다
2. reverse 그래프에서 X
 */

