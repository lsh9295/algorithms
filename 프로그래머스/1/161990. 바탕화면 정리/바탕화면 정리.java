import java.util.*;
/*
최소한의 드래그 범위를 도출.

x좌표를 순서대로 탐색 board[y][x + ...] 첫 번째로 걸리는 문서의 y위치 저장 1
y좌표를 순서대로 탐색 board[y + ...][x] 첫 번째로 걸리는 문서의 x위치 저장 3

맨 뒤부터 x좌표를 줄여가며 탐색. 첫 번째로 걸리는 문서의 y + 1위치 저장 5 
맨 뒤부터 y좌표를 줄여가며 탐색. 첫 번째로 걸리는 문서의 x + 1위치 저장 8
*/

class Solution {
    static char[][] board;
    static int y;
    static int x;
    static int[] answer = new int[4];
    
    public int[] solution(String[] wallpaper) {
        y = wallpaper.length;
        x = wallpaper[0].length();
        board = new char[y][x];
        boolean check = false;
        
        for (int i = 0; i < y; i++) {
            char[] buffer = wallpaper[i].toCharArray();
            
            for (int j = 0; j < x; j++)
                board[i][j] = buffer[j];
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == '#') {
                    answer[0] = i;
                    check = true;
                    
                    break;
                }
            }
            if (check) {
                check = false;
                
                break;
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[j][i] == '#') {
                    answer[1] = i;
                    check = true;
                    
                    break;
                }
            }
            if (check) {
                check = false;
                
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            for (int j = x - 1; j >= 0; j--) {
                if (board[i][j] == '#') {
                    answer[2] = i + 1;
                    check = true;
                    
                    break;
                }
            }
            if (check) {
                check = false;
                
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (board[j][i] == '#') {
                    answer[3] = i + 1;
                    check = true;
                    
                    break;
                }
            }
            if (check) {
                check = false;
                
                break;
            }
        }
        return answer;
    }
}