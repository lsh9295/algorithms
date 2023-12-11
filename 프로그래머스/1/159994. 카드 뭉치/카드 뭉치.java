import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Queue<String> goalQ = new LinkedList<>();
        
        for (String card : cards1)
            q1.offer(card);
        
        for (String card : cards2)
            q2.offer(card);
        
        for (String word : goal)
            goalQ.offer(word);
        
        while (goalQ.peek() != null) {
            if (goalQ.peek().equals(q1.peek())) {
                goalQ.remove();
                q1.remove();
            } else { 
                if (goalQ.peek().equals(q2.peek())) {
                    goalQ.remove();
                    q2.remove();
                } else {
                    return "No";
                }
            }
        }
        return "Yes";
    }
}