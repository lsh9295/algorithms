import java.util.*;

class Solution {
    public int solution(String s) {
        char sign = s.charAt(0);
        String subS = s.substring(1, s.length());
        int answer = Integer.parseInt(subS);
        
        if (sign == '-')
            return answer - 2 * answer;
        else {
            return Integer.parseInt(s);
        }
    }
}