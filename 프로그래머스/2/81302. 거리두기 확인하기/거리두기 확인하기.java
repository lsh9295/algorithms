import java.util.*;

class Node {
    int y, x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static int length = 5;
    static int[] px = {1, 0, -1, 0};
    static int[] py = {0, 1, 0, -1};
    
    static Queue<Node> queue;
    static char[][] board;
    static char[][] visited;
    static int[] answer = {1, 1, 1, 1, 1};
    static int nowY;
    static int nowX;
    
    public int[] solution(String[][] places) {
        for (int i = 0; i < length; i++) { // 1 - 5 대기실 각각의 프로세스
            System.out.println(i + "대기실");
            String[] room = places[i];
            board = new char[length][length];
            
            for (int j = 0; j < length; j++) { // i번째 대기실의 char형 board 초기화
                for (int k = 0; k < length; k++) { 
                    board[j][k] = room[j].charAt(k);
                }
            }
            boolean isEnd = false;
            
            for (int m = 0; m < length; m++) {
                for (int n = 0; n < length; n++) {                    
                    if (board[m][n] == 'P') { // board에서 지원자 발견 시 BFS 수행
                        queue = new LinkedList<>();
                        visited = new char[length][length];
                        nowY = m;
                        nowX = n;
                        
                        queue.offer(new Node(m, n));
                        visited[m][n] = 1;
                        
                        if (BFS()) { // 거리두기 실패시 BFS 종료
                            isEnd = true;
                            answer[i] = 0;
                            break;
                        }
                    }
                }
                if (isEnd)
                    break;
            }     
        }
        return answer;
    }
    
    public static boolean BFS() {
        int level = 0;
        boolean skip = false;
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                Node n = queue.poll();
                
                if (skip) {
                    if (board[n.y][n.x] == 'P' && (Math.abs(nowY - n.y) + Math.abs(nowX - n.x)) <= 2 && level <= 2) {
                        System.out.println("P[" + nowY + ", " + nowX + "]과 " + "P[" + n.y + ", " + n.x + "] 충돌" );

                        return true;
                    }
                }
                
                for (int j = 0; j < 4; j++) {
                    int ny = n.y + py[j];
                    int nx = n.x + px[j];

                    if (ny >= 0 && ny <= 4 && nx >= 0 && nx <= 4 && board[ny][nx] != 'X'){
                        if (visited[ny][nx] == 0) {
							queue.offer(new Node(ny, nx));
							visited[ny][nx] = 1;
                        }
                    }
                }
            }
            skip = true;
            level++;
        }
        return false;
    }
}

/*
[풀이법]
1. P 에서 BFS 출발
2. Queue에서 추출하는 Node의 좌표가 P일때 |발견 P의 y좌표 - n의 y좌표| + |발견 P의 x좌표 - Node의 x좌표| 가 2이하가 아닌 경우
    BFS 종료
3. 대신 X가 있으면 이동시키지 않는다.
4. 모든 조건을 만족하는 경우 answer[i] = 1 초기화

[TC]
"OOOOO"
"OPXPO" [1,1] [1,3] / [1, 1][2, 2]
"OXPXO"
"OPXPO"
"OOOOO"

["POOPX"
 "OOOOP",
 "POOOO",
 "OOOOO",
 "OOOPP"]
*/