import java.util.*;
/**
 * 처음에 1의 개수를 카운팅한다.
 * n의 2진수에 1씩 더해가면서 1의 개수가 카운트 값과 동일해질 때 stop.
 * stop했을 때의 수를 반환한다.
 */
class Solution {
    public int solution(int n) {
        int answer = n;
        int answerCnt = 0; // 다음 큰 수의 1 개수
        int nCnt = 0; // n의 1 개수
        String binary = Integer.toBinaryString(n);
        char[] cList = binary.toCharArray();
        
        for (int i = 0; i < cList.length; i++) {
            if (cList[i] == '1')
                nCnt++;
        }
        
        while (answerCnt != nCnt) {
            answer += 1;
            answerCnt = 0;
            binary = Integer.toBinaryString(answer);
            cList = binary.toCharArray();
        
            for (int i = 0; i < cList.length; i++) {
                if (cList[i] == '1')
                    answerCnt++;
            }
        }
        
        return answer;
    }
}