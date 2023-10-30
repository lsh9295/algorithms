import java.util.*;

class Solution {
    static char[][] board;
    
    static int y;
    static int x;
    
    static int ny;
    static int nx;
    
    public int[] solution(String[] park, String[] routes) {
        y = park.length;
        x = park[0].length();
        board = new char[y][x];
        
        for (int i = 0; i < y; i++) { // 보드 초기화
            char[] buffer = park[i].toCharArray();
                
            for (int j = 0; j < x; j++) {
                board[i][j] = buffer[j];
                
                if (buffer[j] == 'S') {
                    ny = i;
                    nx = j;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String[] split = routes[i].split(" ");
            String op = split[0];
            int dis = Integer.parseInt(split[1]);
            
            move(op, dis);
        }
        int[] answer = {ny, nx};
        
        return answer;
    }
    
    static public void move (String op, int dis) {
        switch(op) {
            case "S" :
                if (ny + dis < y && ny + dis >= 0) {
                    for (int i = 1; i <= dis; i++) {
                        if (board[ny + i][nx] == 'X')
                            return;
                    }
                    ny += dis;
                }
                break;
                
            case "N" :
                if (ny - dis >= 0) {
                    for (int i = 1; i <= dis; i++) {
                        if (board[ny - i][nx] == 'X')
                            return;
                    }
                    ny -= dis;
                }
                break;
                
            case "W" :
                if (nx - dis >= 0) {
                    for (int i = 1; i <= dis; i++) {
                        if (board[ny][nx - i] == 'X')
                            return;
                    }
                    nx -= dis;
                }
                break;
                
            case "E" :
                if (nx + dis < x && nx + dis >= 0) {
                    for (int i = 1; i <= dis; i++) {
                        if (board[ny][nx + i] == 'X')
                            return;
                    }
                    nx += dis;
                }
                break;
        }
    }
}