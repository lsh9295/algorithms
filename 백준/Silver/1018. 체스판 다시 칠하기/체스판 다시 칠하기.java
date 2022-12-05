import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) { // 체스판 입력 및 초기화
            String line = br.readLine();
            String[] split = line.split("");
            
            for (int j = 0; j < M; j++) {
                board[i][j] = split[j];
            }
        }
        System.out.println(getMinPaint(N, M, board));
    }
    private static int getMinPaint(int N, int M, String[][] board) { // 8*8 체스판 기준 가장 작게 색칠하는 케이스 반환
        int paint = 0;
        int min = 10000;

        for (int c = 0; c < 2; c++) {
            if (c == 0) { // 맨 처음을 B라고 생각하고 칠하는 케이스
                for (int i = 0; i <= N - 8; i++) {
                    for (int j = 0; j <= M - 8; j++) {
                        String firstColor = board[i][j]; // 가장 왼쪽 위 정사각형의 색깔

                        if (firstColor.equals("B")) { // 가장 왼쪽 위가 B일 때
                            paint = caseB(board, paint, i, j);
                        } else if (firstColor.equals("W")) {
                            paint = caseW(board, paint, i, j);
                        }
                        if (paint < min)
                            min = paint;
                        
                        paint = 0;
                    }
                }
            } else if (c == 1) { // 맨 처음을 W로 바꿔서 칠하는 케이스
                for (int i = 0; i <= N - 8; i++) {
                    for (int j = 0; j <= M - 8; j++) {
                        String firstColor = board[i][j]; // 가장 왼쪽 위 정사각형의 색깔

                        if (firstColor.equals("B")) { // 가장 왼쪽 위가 B일 때
                            paint = caseW(board, paint, i, j);
                        } else if (firstColor.equals("W")) {
                            paint = caseB(board, paint, i, j);
                        }
                        if (paint < min)
                            min = paint;
                        
                        paint = 0;
                    }
                }
            }
        }
        return min;
    }
    private static int caseW(String[][] board, int paint, int i, int j) {
        for (int k = 0; k < 8; k++) {
            if (k % 2 == 0)  // 짝수번째 행일 때
                paint = findOdd(board, paint, i, j, k);
            else if (k % 2 == 1)  // 홀수번째 행일 때
                paint = findEven(board, paint, i, j, k);
        }
        return paint;
    }
    private static int caseB(String[][] board, int paint, int i, int j) {
        for (int k = 0; k < 8; k++) {
            if (k % 2 == 0) // 짝수번째 행일 때
                paint = findEven(board, paint, i, j, k);
            else if (k % 2 == 1) // 홀수번째 행일 때
                paint = findOdd(board, paint, i, j, k);
        }
        return paint;
    }
    private static int findEven(String[][] board, int paint, int i, int j, int k) {
        for (int l = 0; l < 8; l++) {
            if (l % 2 == 0) { // 짝수 열이 B인지 확인
                if (!board[i + k][j + l].equals("B"))
                    paint++;
            } else { // 홀수 열이 W인지 확인
                if (!board[i + k][j + l].equals("W"))
                    paint++;
            }
        }
        return paint;
    }
    private static int findOdd(String[][] board, int paint, int i, int j, int k) {
        for (int l = 0; l < 8; l++) {
            if (l % 2 == 0) { // 짝수 열이 W인지 확인
                if (!board[i + k][j + l].equals("W"))
                    paint++;
            } else { // 홀수 열이 B인지 확인
                if (!board[i + k][j + l].equals("B"))
                    paint++;
            }
        }
        return paint;
    }
}
/*
 * 어쨌든 8칸 안에는 흰 4 검 4로 존재해야하기 때문에 이 수를 맞춰주면 되지 않을까? -> X
 * 위 방법으로 시도해보고 마지막 테스트케이스에서 걸리는 것을 확인.
 * 따라서 가장 왼쪽 위의 색을 통해 각각의 정사각형을 비교 -> O
 */