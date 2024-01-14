import java.util.*;

class Solution {
    public String solution(int[] food) {
        int[] foodList = food;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < foodList.length; i++) {
            if (foodList[i] % 2 == 1)
                foodList[i] -= 1;
                
            foodList[i] /= 2;
        }
        for (int i = 1; i < foodList.length; i++) {
            for (int j = 0; j < foodList[i] ; j++) {
                sb.append(i);        
            }
        }
        String answer = sb.toString();
        answer += "0";
        
        sb.reverse();
        answer += sb;
        
        return answer;
    }
}

// 1. 0번을 제외하고 만약 음식의 개수가 홀수면 -1을 해줘서 짝수로 만들어줌
// 2. 음식을 차례대로 나열
// 3. 0을 붙이고 나열한 음식의 reverse를 다시 붙임