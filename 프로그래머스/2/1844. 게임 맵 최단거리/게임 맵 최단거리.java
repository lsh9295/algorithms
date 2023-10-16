import java.util.*;

public class Node {
    int y;
    
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static Queue<Node> q = new LinkedList<>();
    static int[][] board;
    static int answer = 0;
    static int[] py = {1, -1, 0, 0};
    static int[] px = {0, 0, 1, -1};
    static boolean isEnd = false;
    static boolean[][] visited;
    static int M, N;

    public int solution(int[][] maps) {
        board = maps;
        M = maps.length;
        N = maps[0].length;
        visited = new boolean[M][N];
        
        visited[0][0] = true;
        q.offer(new Node(0, 0));
        BFS();

        if (!isEnd) {
            answer = -1;
        }
        return answer;
    }

    public static void BFS() {
        int num = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            
            for (int i = 0; i < len; i++) {
                Node n = q.poll();

                if (n.y == M - 1 && n.x == N - 1) {
                    answer = num;
                    isEnd = true;
                    return;
                }
            
                for (int j = 0; j < 4; j++) {
                    int ny = n.y + py[j];
                    int nx = n.x + px[j];

                    if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                        if (!visited[ny][nx] && board[ny][nx] == 1) {
                            q.offer(new Node(ny, nx));
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
            num++;
        }
    }
}