import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] check = new boolean[cards.length]; // 상자 방문 여부
        int[] points = new int[cards.length];

        for (int i = 0; i < cards.length; i++) {
            int now = i; // 현재 방문 노드 위치
            int point = 0;

            while (!check[now]) {
                check[now] = true;
                point++;
                now = cards[now] - 1;
            }
            points[i] = point;
        }

        Arrays.sort(points);

        answer = points[cards.length - 1] * points[cards.length - 2];
        return answer;
    }
}