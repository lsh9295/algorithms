import java.io.*;
import java.util.*;

/**
 * Baekjoon 1931 회의실 배정
 */
class Main {
    static class Meeting implements Comparable<Meeting>  {
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }
    static List<Meeting> meetingList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int answer = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            meetingList.add(new Meeting(A, B));
        }
        Collections.sort(meetingList); // 회의가 끝나는 순으로 솔팅
        int nowEnd = meetingList.get(0).end;

        for (int i = 1; i < meetingList.size(); i++) {
            Meeting meet = meetingList.get(i);

            if (meet.start >= nowEnd) {
                nowEnd = meet.end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}