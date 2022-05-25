import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new LinkedList<>();

        int[] buf = new int[progresses.length];
        int idx = 0; // 100으로 빠질때마다 늘려주기
        int cnt = 0; // 하루에 배포되는 기능의 갯수
        int day = 0;
        for (int i = 0; i < progresses.length; i++) {
            buf[i] = progresses[i];
        }
        while (idx != progresses.length) {
            for (int i = idx; i < progresses.length; i++) {
                buf[i] = buf[i] + speeds[i];
            }
            while (buf[idx] >= 100) {
                idx++;
                cnt++;
                if (idx == progresses.length)
                    break;
            }
            if (cnt > 0) {
                answer.add(cnt);
                day++;
                cnt = 0;
            }
        }
        int[] quearr = new int[answer.size()];
        for (int i = 0; i < quearr.length; i++) {
            quearr[i] = answer.poll();
        }
        return quearr;
    }
}