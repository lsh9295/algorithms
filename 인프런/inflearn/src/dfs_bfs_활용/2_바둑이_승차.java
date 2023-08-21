package dfs_bfs_활용;

import java.io.*;
import java.util.*;

/*
  C - 트럭 제한 무게
  N - 바둑이 수
  W - 각 바둑이 무게
  트럭 제한 무게를 넘지 않는 선에서 바둑이들을 가장 최대 무게에 가깝게 얼마나 실을 수 있는지
 */
public class Main {
    static int maxWeight = 0;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        maxWeight = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] jindols = new int[N + 1];

        for (int i = 1 ; i < N + 1; i++) {
            jindols[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0, jindols);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, int[] jindols) {
        if (sum > maxWeight)
            return;
        else {
            if (sum > answer)
                answer = sum;
        }

        if (level < jindols.length) {
            DFS(level + 1, sum + jindols[level], jindols);
            DFS(level + 1, sum, jindols);
        }
    }
}