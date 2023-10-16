import java.util.*;

class Solution {
    static int answer;
    static int K;
    static int[][] room;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        room = dungeons;
        visited = new boolean[room.length];
        
        DFS(0, k);
        
        return answer;
    }
    
    public static void DFS(int level, int k) {
        if (level > answer)
            answer = level;
        
        for (int i = 0; i < room.length; i++) {
            if (visited[i]) continue;
            
            if (room[i][0] <= k && k - room[i][1] >= 0) {
                visited[i]  = true;
                DFS(level + 1, k - room[i][1]);
                visited[i] = false;
            }
        }
    }
}

/**
* 순열(DFS), 모든 케이스 탐색 후 가장 level이 높은 값을 출력
*
*/