package stack_queue;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        int cnt = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            cnt++;
            if (cnt == K) {
                answer = queue.poll();
                cnt = 0;
            } else {
                queue.offer(queue.poll());
            }
        }
        System.out.println(answer);
    }
}