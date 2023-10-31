import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 1;
        int y = board.length;
        int x = board[0].length;
        int[][] map = new int[y + 1][x + 1];
        boolean isZero = true;
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] != 0) {
                    isZero = false;
                    break;
                }
            }
            if (!isZero)
                break;
        }
        
        if (isZero)
            return 0;
        
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                map[i][j] = board[i - 1][j - 1];
            }
        }
        
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (map[i][j] == 0)
                    continue;
                
                int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                map[i][j] = min;
                
                if (min * min > answer) {
                    answer = min * min;
                }
            }
            
        }
        return answer;
    }
}