import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayList<Character> list = new ArrayList<>();
        char[] cList = s.toCharArray();
        int answer = 0;
        
        if (s.length() % 2 == 1)
            return 0;
        
        for (int i = 0; i < s.length(); i++) 
            list.add(cList[i]);

        for (int i = 0; i < s.length(); i++) { // 회전할 때마다 반복
            boolean isPerfect = true; // 완벽한 문자열인지?
            Stack<Character> stack = new Stack<>();
            int idx = 0;
            
            while (isPerfect && idx < s.length()) {
                if (!stack.isEmpty()) { // 스택이 비어있지 않으면
                    if (stack.peek() == ')' || stack.peek() == ']' || stack.peek() == '}') {
                        isPerfect = false;
                        break;
                    } else { // {, [, (
                        Character nowC = stack.peek(); // {, [, (
                        stack.push(list.get(idx));
                        
                        if ((nowC == '(' && stack.peek() == ')') || 
                            (nowC == '{' && stack.peek() == '}') ||
                            (nowC == '[' && stack.peek() == ']')) {
                            stack.pop();
                            stack.pop();
                        } 
                    }
                } else { // 스택이 비어있으면
                    stack.push(list.get(idx));
                }
                idx++;
            }
            if (isPerfect)
                answer++;
            
            Character c = list.remove(0); // 괄호 문자열 회전
            list.add(c);
        }
        return answer;
    }
}