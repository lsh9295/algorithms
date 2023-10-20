import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() == arr[i]) {
                continue;
            } else {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        int i = stack.size() - 1;
        
        while(!stack.isEmpty()) {
            answer[i] = stack.pop();
            i--;
        }
        return answer;
    }
}