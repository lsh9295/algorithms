import java.util.*;

class Solution {
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    
    public int solution(int n, int[][] wires) {        
        for (int j = 0; j < wires.length; j++) {
            board = new int[n + 1][n + 1];
            visited = new boolean[n + 1];   
            
            for (int i = 0; i < wires.length; i++) {
                if (j == i) continue; // 전력망 하나 제거
                
                board[wires[i][0]][wires[i][1]] = 1;
                board[wires[i][1]][wires[i][0]] = 1;
            }
            int cnt = BFS();
            System.out.println(j + " " + Math.abs((n - cnt) - cnt));
            if (answer > Math.abs((n - cnt) - cnt))
                answer = Math.abs((n - cnt) - cnt);
        }
        return answer;
    }
    
    public static int BFS() {
        int level = 0;
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int i = 1; i < board.length; i++) {
                if (board[node][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
            level++;
        }
        return level;
    }
}