import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : works)
            pq.offer(i);
        
        for (int i = 0; i < n; i++) {
            int num = pq.remove();
            
            if (num == 0)
                return 0;
        
            num--;
            pq.offer(num);
        }
        for (int i = 0; i < works.length; i++) 
            answer += Math.pow(pq.remove(), 2);
        
        return answer;
    }
}

/*
[TC]
1. [6, 4, 3, 1, 1] / n = 5
2. [5, 4, 3, 1, 1] / n = 5 - 1 -> 4
3. [4, 4, 3, 1, 1]  n = 5 - 2 -> 3
4. [3, 4, 3, 1, 1]  n = 5 - 3 -> 2
5. [3, 3, 3, 1, 1]  n = 5 - 4 -> 1
6. [2, 3, 3, 1, 1] n = 5 - 5 -> 0
답 = 24

400000000
*/