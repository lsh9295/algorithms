public class Solution {

    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = solution(numbers, hand);
        System.out.printf("%s", answer);
    }

    public static String solution(int[] numbers, String hand) {

        String answer = "";
        StringBuilder sb = new StringBuilder("");
        int left_hand = 10;
        int right_hand = 12;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append('L');
                left_hand = numbers[i];
            } // 왼손 터치
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append('R');
                right_hand = numbers[i];
            } // 오른손 터치
            else {
                if (numbers[i] == 0)
                    numbers[i] = 11;

                int left_loc = (Math.abs(numbers[i] - left_hand)) / 3 + (Math.abs(numbers[i] - left_hand)) % 3;
                int right_loc = (Math.abs(numbers[i] - right_hand)) / 3 + (Math.abs(numbers[i] - right_hand)) % 3;

                if (left_loc == right_loc) {
                    if (hand.equals("left")) {
                        sb.append('L');
                        left_hand = numbers[i];
                    } else {
                        sb.append('R');
                        right_hand = numbers[i];
                    }
                } else if (left_loc < right_loc) {
                    sb.append('L');
                    left_hand = numbers[i];
                } else {
                    sb.append('R');
                    right_hand = numbers[i];
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}