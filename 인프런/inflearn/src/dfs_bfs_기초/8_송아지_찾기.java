package dfs_bfs_기초;

import java.util.*;
import java.io.*;

public class Main{
    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();
    public static int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();

                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];

                    if (x == e) return answer;

                    if ((nx >= 1 && nx <= 10000) && ch[nx] == 0) {
                        Q.offer(nx);
                        ch[nx] = 1;
                    }
                }
            }
            answer++;
        }
        return -1;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(BFS(s, e));
    }
}