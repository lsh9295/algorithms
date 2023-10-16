import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int maxLen = brown + yellow;
        ArrayList<Integer> list = new ArrayList<>();
        
        // 약수 구하기
        for (int i = 1; i <= maxLen; i++) {
            if (maxLen % i == 0)
                list.add(i);
        }
        if (list.size() % 2 == 0) { // 짝수
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if ((list.get(i) - 2) * (list.get(j) - 2) == yellow) {
                        answer[0] = list.get(j);
                        answer[1] = list.get(i);
                    }
                }
            }
        } else { // 홀수
            answer[0] = list.get(((list.size() + 1) / 2) - 1);
            answer[1] = list.get(((list.size() + 1) / 2) - 1);
        }
        return answer;
    }
}