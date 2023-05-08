import java.util.*;

class Solution {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<>();

        String[] todayYmd = today.split("\\."); // 0 = YYYY, 1 = MM, 2 = DD
        HashMap<String, Integer> map = new HashMap<>(); // <약관종류 , 유효기간> 해시맵

        // 약관 종류와 유효기간 초기화
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        // 정책 만료기간 검사
        int i = 1; // 정책의 인덱스
        for (String privacy : privacies) {
            String[] s = privacy.split(" "); // 0 = 보관 종료 날짜, 1 = 약관 종류
            String[] expireYmd = s[0].split("\\."); // 0 = YYYY, 1 = MM, 2 = DD

            int period = map.get(s[1]); // 해당 정책의 유효기간

            int[] intToday = {Integer.parseInt(todayYmd[0]),Integer.parseInt(todayYmd[1]),
                    Integer.parseInt(todayYmd[2])};
            int[] intExpire = {Integer.parseInt(expireYmd[0]),Integer.parseInt(expireYmd[1]),
                    Integer.parseInt(expireYmd[2])};

            // 보관 날짜
            if (period + intExpire[1] > 12) {
                int n = (period + intExpire[1]) / 12;
                int m = (period + intExpire[1]) % 12;
                if (m == 0) {
                    intExpire[0] += (n - 1);
                    intExpire[1] = 12;
                } else {
                    intExpire[0] += n;
                    intExpire[1] = m;
                }
            } else {
                intExpire[1] += period;
            }


            int toDayDayChange = intToday[1] * 28 + intToday[2];
            int expireDayChange = intExpire[1] * 28 + intExpire[2];

            if (intToday[0] > intExpire[0]) {
                answerList.add(i);
            } else if (intToday[0] == intExpire[0] && toDayDayChange >= expireDayChange) {
                answerList.add(i);
            }
            i++;
        }
        int[] answer = new int[answerList.size()];
        for (int j = 0; j < answer.length; j++) {
            answer[j] = answerList.get(j);
        }

        return answer;
    }
}