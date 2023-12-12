import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char nowA = s.charAt(i);
            int decodeCnt = 0;
            
            for (int j = 0 ; j < index; j++) { // 복호화 프로세스
                decodeCnt++;
                char decode = (char) ((nowA + decodeCnt - 'a') % 26 + 'a');
                
                if (skip.contains(String.valueOf(decode)))
                    j--;
            }
            char result = (char) ((nowA - 'a' + decodeCnt) % 26 + 'a');
            sb.append(result);
        }
        return sb.toString();
    }
}
/* [풀이법]
1. 현재 알파벳 하나를 꺼낸다.
2. 현재 알파벳의 index만큼 뒤의 알파벳 n개를 검사
3. 만약 알파벳 a가 skip에 포함되어 있으면 j--를 한 후 continue
4. 만약 알파벳 a가 skip에 포함되어 있지 않으면 그대로 진행
5. z를 넘어갈 경우 해당 알파벳의 96 + a의 정수형 ASCII % 97
6. sb return
*/