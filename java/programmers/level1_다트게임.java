import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        System.out.println(sol.solution(a));
    }

    public int solution(String dartResult) {

        int len = dartResult.length();
        char[] parsing = new char[len];
        int answer = 0;
        int[] numList = new int[3];
        double num = 0;
        int i = 0;
        int cnt = -1;

        for (int j = 0; j < len; j++) {    // 문자열 파싱
            parsing[j] = dartResult.charAt(j);
        }
        while (i < len) {
            cnt++;

            if (parsing[i] >= '0' && parsing[i] <= '9') { // atoi 변환
                if (parsing[i] == '1' && parsing[i + 1] == '0') { // 10인 경우 예외처리
                    num = 10;
                    i += 2;
                } else {
                    num = parsing[i] - '0';
                    i++;
                }
            }
            if (parsing[i] == 'S' || parsing[i] == 'D' || parsing[i] == 'T') { // S, D, T 제곱 프로세스
                if (parsing[i] == 'D') {
                    num = Math.pow(num, 2);
                } else if (parsing[i] == 'T') {
                    num = Math.pow(num, 3);
                }
                i++;
                if (i == len) { // 마지막 문자일 경우 종료
                    numList[cnt] = (int) num;
                    break;
                }
            }
            if (parsing[i] == '#' || parsing[i] == '*') { // #, * 보너스 프로세스
                if (parsing[i] == '#') { // 해당 넘버 마이너스
                    num = -num;
                } else if (parsing[i] == '*') { // 해당 넘버와 직전 넘버 * 2
                    if (i >= 3)
                        numList[cnt - 1] *= 2;
                    num *= 2;
                }
                i++;
                if (i == len) { // 마지막 문자일 경우 종료
                    numList[cnt] = (int) num;
                    break;
                }
            }
            numList[cnt] = (int) num;
        }
        for (int k = 0; k < 3; k++) {
            answer += numList[k];
        }
        return answer;
    }
}