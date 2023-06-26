import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 학급 인원 N(5<=N<=50)
        String pick = br.readLine(); // 투표한 후보 순서
        char[] pickList = pick.toCharArray();
        char elected = 'A'; // 당선 친구
        int max = 0; // 최대 득표 수

        HashMap<Character, Integer> candidate = new HashMap<>(); // 후보 득표 해시맵
        candidate.put('A', 0);
        candidate.put('B', 0);
        candidate.put('C', 0);
        candidate.put('D', 0);
        candidate.put('E', 0);

        for (int i = 0; i < N; i++) // 해시맵 +1 증가 프로세스
            candidate.put(pickList[i], candidate.get(pickList[i]) + 1);

        for (Map.Entry<Character, Integer> entry : candidate.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                elected = entry.getKey();
            }
        }
        System.out.println(elected);
    }
}