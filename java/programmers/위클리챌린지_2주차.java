public class Solution {

    public static void main(String[] args) {

        int scores[][] = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
        System.out.printf("%s", solution(scores));
    }

    public static String solution(int[][] scores) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {

            double ever_temp = 0;
            int max = -1;
            int min = 101;
            int divide = scores.length;
            boolean only = true;

            for (int j = 0; j < scores.length; j++) {
                if (scores[j][i] > max)
                    max = scores[j][i];
                if (scores[j][i] < min)
                    min = scores[j][i];
                ever_temp += scores[j][i];
            }

            for (int k = 0; k < scores.length; k++) { // !유일 최대값 최소값 검사!
                if (k == i)
                    continue;
                if (max == scores[i][i] && max == scores[k][i])
                    only = false;
                if (min == scores[i][i] && min == scores[k][i])
                    only = false;
            }

            if ((scores[i][i] == max && only) || (scores[i][i] == min && only)) {
                ever_temp -= scores[i][i];
                divide--;
            }

            ever_temp = ever_temp / divide;
            System.out.println(ever_temp);

            if (ever_temp >= 90)
                sb.append("A");
            else if (ever_temp >= 80)
                sb.append("B");
            else if (ever_temp >= 70)
                sb.append("C");
            else if (ever_temp >= 50)
                sb.append("D");
            else if (ever_temp < 50)
                sb.append("F");
        }
        answer = sb.toString();
        return answer;
    }
}
// scores[0][0~4] == 0번이 0 1 2 3 4 에게 준 점수
// 자신이 매긴 자신의 점수가 최고점, 최저점이면 제외하기.