import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {
            if (pq.size() >= k) {
                pq.offer(score[i]);
                pq.remove();
                answer[i] = pq.peek();
            } else {
                pq.offer(score[i]);
                answer[i] = pq.peek();
            }
        }
        return answer;
    }
}

/*
[풀이법]
1. 매일 한 명의 가수가 무대를 서고 점수를 받음
2. 해당 가수가 상위 k번째 이내면 명예의 전당 등록
3. 매일 명예의 전당의 k번째(턱걸이)의 점수를 반환

PriorityQueue를 사용하여 k 이상의 수가 큐에 삽입될 떄
항상 가장 작은 수를 빼내고 배열에 삽입 후 정답 return

[TC]
*/