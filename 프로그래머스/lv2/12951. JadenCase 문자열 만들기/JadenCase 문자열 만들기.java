import java.util.*;

class Solution {
    public String solution(String s) {
        char[] cList = s.toCharArray();
        
        if (cList[0] >= 'a' && cList[0] <= 'z') cList[0] -= 32;
        
        for (int i = 1; i < cList.length; i++) {
            if (cList[i] == ' ') {
                while (cList[i] == ' ' && i < cList.length - 1) {
                    if (cList[i + 1] >= 'a' && cList[i + 1] <= 'z')
                        cList[i + 1] -= 32;
                    i++;
                }
            } else if (cList[i] >= 'A' && cList[i] <= 'Z') {
                cList[i] += 32;
            }
        }
        String answer = new String(cList);
        
        return answer;
    }
}