package dfs_bfs_활용;

import java.util.*;
import java.io.*;

/**
 * 0 -> 빈칸 / 1 -> 집 / 2 -> 피자집
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
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static int len;
    static ArrayList<Node> pz, hs;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pz = new ArrayList<>();
        hs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    hs.add(new Node(i, j));
                } else if (num == 2) {
                    pz.add(new Node(i, j));
                }
            }
        }
        len = pz.size();
        combi = new int[M]; // len C combi
        DFS(0, 0);

        System.out.println(answer);
    }

    public static void DFS(int L, int s) {
        if (L == M) {
            int sum = 0;
            for (Node n : hs) {
                int dis=Integer.MAX_VALUE;

                for (int i : combi) { // 0 1 2 3
                    dis = Math.min(dis, Math.abs(n.y - pz.get(i).y) + Math.abs(n.x - pz.get(i).x));
                }
                sum += dis;
            }
            answer= Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
