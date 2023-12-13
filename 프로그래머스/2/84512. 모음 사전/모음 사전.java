import java.util.*; 

class Solution {
    static int answer = -1;
    static String answerWord;
    static boolean isEnd;
    static String[] wordList = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        answerWord = word;
        DFS(0, "");
        
        return answer;
    }
    
    public static void DFS(int level, String str) {       
        if (isEnd)
            return;
        
        answer++;
        
        if (answerWord.equals(str)) {
            isEnd = true;
            System.out.println(str);
            return;
        }

        if (level == 5)
            return;
           
        for (int i = 0; i < 5; i++) {
            DFS(level + 1, str + wordList[i]);
        }
    }
}
