import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] scores = new Integer[score.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < scores.length; i++)
            scores[i] = score[i];
    
        Arrays.sort(scores, Collections.reverseOrder());
        
        for (int i : scores)
            queue.offer(i);
         
        while (m <= queue.size()) {
            for (int i = 0; i < m; i++) {
                if (i == m - 1) {
                    int now = queue.peek();
                    answer += now * m;
                }
                queue.poll();
            }
        }
        return answer;
    }
}
