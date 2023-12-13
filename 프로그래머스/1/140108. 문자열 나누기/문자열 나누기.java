
import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(String s) {
        String str = s;
        
        while (!str.isEmpty()) 
            str = parser(str);

        return answer;
    }
    
    public static String parser(String str) { 
        char firstChar = str.charAt(0);
        int firstCnt = 1;
        int otherCnt = 0;
        
        // case 1 예외처리
        if (str.length() == 1) {
            answer++;
            
            return "";
        }
        
        for (int i = 1 ; i < str.length(); i++) {
            char otherChar = str.charAt(i);
            
            if (firstChar == otherChar)
                firstCnt++;
            else 
                otherCnt++;
            
            if (firstCnt == otherCnt) {
                answer++;
                
                return str.substring(firstCnt + otherCnt, str.length());
            }
        }
        answer++;
        
        return ""; // 분해되지 않으면 answer++ 후 "" 반환   
    }
}

/* [풀이법]
1. 첫 글자 x
2. 문자열 읽으면서 문자 x가 나온 횟수와 / x가 아닌 문자가 나온 횟수가 같아지면 문자열 분리
3. 분리된 문자열 이후로 리셋 후 다시 1, 2번 과정 진행

tc
1. abcde
*/