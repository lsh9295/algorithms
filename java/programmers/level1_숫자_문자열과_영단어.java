import java.util.HashMap;

class Solution {
    public static int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        int answer = 0;
        String temp = "";

        for (int i = 0; i < s.length(); i++) {

            char ch_buf = s.charAt(i); // s 문자열의 i번째 인덱스 하나 저장

            if ((ch_buf - '0') >= 0 && (ch_buf - '0') <= 9) {
                answer = answer * 10 + (ch_buf - '0');
                continue;
            }
            temp = temp + s.charAt(i);
            if (map.containsKey(temp)) {
                answer = answer * 10 + map.get(temp);
                temp = "";
            }
        }
        return answer;
    }
}