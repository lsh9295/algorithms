import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[][] board = {{0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 3},
                         {0, 2, 5, 0, 1},
                         {4, 2, 4, 4, 2},
                         {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = solution(board, moves);
        System.out.printf("%d\n", result);
    }

    public static int solution(int[][] board, int[] moves) {
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
        return answer * 2; //인형 갯수
    }
}