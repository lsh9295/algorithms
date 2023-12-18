import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node>{
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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine());

        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);

        System.out.println(dist[endNode]);
        br.close();
    }
    static void dijkstra(int startNode) {
        boolean[] visited = new boolean[dist.length + 1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(startNode, 0));
        dist[startNode] = 0;

        Arrays.fill(visited, false);

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.node])
                continue;
            
            visited[now.node] = true;

            for (Node next : graph[now.node]) {
                if (dist[next.node] > dist[now.node] + next.cost) {
                    dist[next.node] = dist[now.node] + next.cost;
                    q.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
