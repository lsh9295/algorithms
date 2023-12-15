import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] wordList;
    static String cBegin;
    static String cTarget;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean isEnd = true;
        visited = new boolean[words.length];
        wordList = words;
        cBegin = begin;
        cTarget = target;
        
        for (String word : words) { // 예외처리 case(1)
            if (target.equals(word)) {
                   isEnd = false;
            }        
            if (!isEnd)
                break;
        }
        if (isEnd) // words 안에 target이 없으면 종료
            return 0;
        
        DFS(0, begin);  
        
        return answer;
    }
    
    public static void DFS(int level, String now) {
        if (now.equals(cTarget)) {
            answer = level;
            
            return;
        }
        
        for (int i = 0; i < wordList.length; i++) {
            if (visited[i])
                continue;
            
            int sameCnt = 0;
            
            for (int j = 0; j < now.length(); j++) {
                if (now.charAt(j) == wordList[i].charAt(j)) {
                    sameCnt++;
                }    
            }
            
            if (sameCnt == now.length() - 1) {
                visited[i] = true;
                DFS(level + 1, wordList[i]);
                visited[i] = false;
            }
        }
    }
}

/* [풀이법]
1. 단어 집합(words)의 순서는 상관 없음
2. words에 target이 없으면 바로 0 return
*/