import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().trim().split(" ");

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        int k = Integer.parseInt(br.readLine().trim());
        int[] moves = new int[k];
        String[] movesInput = br.readLine().trim().split(" ");

        for (int i = 0; i < k; i++) {
            moves[i] = Integer.parseInt(movesInput[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int loc;
        int temp;

        stack.add(0);

        for (int i = 0; i < moves.length; i++) {
            loc = moves[i] - 1;
            temp = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][loc] == 0)
                    continue;

                temp = board[j][loc];

                if (stack.peek() == temp) {
                    board[j][loc] = 0;
                    stack.pop();
                    answer++;
                    break;
                } else {
                    board[j][loc] = 0;
                    stack.add(temp);
                    break;
                }
            }
        }
        System.out.println(answer * 2);
    }
}