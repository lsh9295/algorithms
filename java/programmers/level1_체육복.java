import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] lost = {2, 3, 4}; // 도난 당한애들
        int[] reserve = {3, 4, 5}; // 여벌 가져온 애들
        int n = 5; // 전체학생 수
        int result = solution(n, lost, reserve);
        System.out.printf("%d\n", result);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 정확히 가져온 애들 수 저장
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) { // 여벌 가져온 애들이 도난당함 검사

                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {

                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}