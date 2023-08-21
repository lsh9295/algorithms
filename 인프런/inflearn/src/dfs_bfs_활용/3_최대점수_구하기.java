package dfs_bfs_활용;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int answer = 0;

    public static class Question {
        int point;
        int time;

        public Question(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int point = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            Question question = new Question(point, time);

            questions.add(question);
        }
        DFS(0, 0, 0, questions);
        System.out.println(answer);
    }

    public static void DFS(int level, int pointSum, int timeSum, List<Question> questions) {
        if (timeSum > M) {
            return;
        } else {
            if (pointSum > answer) {
                answer = pointSum;
            }
        }

        if (level == N) {
            return;
        } else {
            DFS(level + 1, pointSum + questions.get(level).point,
                    timeSum + questions.get(level).time, questions);
            DFS(level + 1, pointSum, timeSum, questions);
        }
    }
}