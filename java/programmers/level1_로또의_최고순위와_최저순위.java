public class Solution {

    public static void main(String[] args) {

        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] result = solution(lottos, win_nums);
        System.out.printf("%d\n", result[0]);
        System.out.printf("%d", result[1]);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        answer[0] = highest_Number(lottos, win_nums);
        answer[1] = lowest_Number(lottos, win_nums);
        return answer;
    }

    public static int lowest_Number(int[] lottos, int[] win_nums) {

        int cnt = 0;
        int rank = 1;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j])
                    cnt++;
            }
        }
        for (int i = 6; i >= 0; i--) {
            if (cnt == i) {
                if (cnt == 1 || cnt == 0)
                    return 6;
                return rank;
            }
            rank++;
        }
        return 0;
    }

    public static int highest_Number(int[] lottos, int[] win_nums) {

        int cnt = 0;
        int zero = 0;
        int sum;
        int rank = 1;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j])
                    cnt++;
            }
        }
        sum = cnt + zero;
        for (int i = 6; i >= 0; i--) {
            if (sum == i) {
                if (sum == 1 || sum == 0)
                    return 6;
                return rank;
            }
            rank++;
        }
        return 0;
    }
}