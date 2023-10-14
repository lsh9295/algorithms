import java.util.*;
import java.io.*;

/*
 * 압축 케이스 = count(문자열 길이)
 * 제일 앞부터 정해진 길이만큼 자르니까 압축 길이만큼 인덱스 증가해야함
 */
class Solution {
    public int solution(String s) {
        int answer = s.length();
        int min = 1001;
        int cnt = 1;
        for (int i = 1; i <= s.length() / 2; i++) { // 문자열 길이 / 2 만큼의 압축 케이스 순회
            StringBuilder sb = new StringBuilder();
            String comp = s.substring(0, i); // 초기값;

            for (int j = i; j < s.length(); j += i) { // 01234567   0246 + c 036 + c
                int endIdx = Math.min(i + j, s.length());

                if (comp.equals(s.substring(j, endIdx))) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(comp);

                    comp = s.substring(j, endIdx);
                    cnt = 1;
                }
            }
        }
        return answer;
    }
}