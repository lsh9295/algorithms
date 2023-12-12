import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        int i = 0;
        
        if (length == 1) {
            char pc = p.charAt(0);
            
            for (int k = 0; k < t.length(); k++) {
                char tc = t.charAt(k);
                
                if (tc <= pc)
                    answer++;
            }
            return answer;
        }
        
        while (i + length <= t.length()) {
            String s = t.substring(i, i + length);
            
            if (p.length() > s.length())
                answer++;
            else {
                int j = 0;
                    
                while (j < length) {
                    char a = s.charAt(j);
                    char b = p.charAt(j);

                    if (a > b) {
                        break;
                    } else if (a < b) {
                        answer++;
                        break;
                    }
                    j++;
                }
                if (j == length)
                    answer++;
            }
            i++;
        }
        return answer;
    }
}

// a 12345678
// b 12354321