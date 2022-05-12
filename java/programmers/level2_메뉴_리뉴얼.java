import java.util.*;

public class Solution {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        String[] orders = {"XYZ", "XWY", "WXA" };
        int[] course = { 2, 3, 4 };
        String[] answer = solution(orders, course);

        for (int i = 0; i < answer.length; i++)
            System.out.printf("%s\n", answer[i]);
    }

    public static void combination(char[] orders, String temp, int n, int r, int start) {

        if (r == 0) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        } else {
            for (int i = start; i < orders.length; i++) {
                combination(orders, temp + orders[i], n, r - 1, i + 1);
            }
        }
    } // 백트래킹 조합

    public static String[] solution(String[] orders, int[] course) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {

            char[] arrchar = orders[i].toCharArray();
            Arrays.sort(arrchar);
            orders[i] = String.valueOf(arrchar);
        } // 각각의 orders 메뉴들 오름차순 정렬

        for (int i = 0; i < course.length; i++) {

            map = new HashMap<>(); // 코스마다 새로운 맵 생성

            for (int j = 0; j < orders.length; j++) {

                char[] one_order = orders[j].toCharArray();

                if (course[i] <= one_order.length)
                    combination(one_order, "", one_order.length, course[i], 0);
            }
            if (!map.isEmpty()) {
                int maxValue = Collections.max(map.values());

                for (Map.Entry<String, Integer> m : map.entrySet()) {

                    if (m.getValue() == maxValue && m.getValue() > 1) { // 큰거랑 두 개 이상 나온 것들만 리스트 삽입
                        list.add(m.getKey());
                    }
                }
            } // 최고 Value 구하기
        }
        Collections.sort(list); // ArrayList 오름차순 정렬

        String[] answer = new String[list.size()];
        int size = 0;

        for(String temp : list){
            answer[size++] = temp;
        } // ArrayList 배열 변환
        return answer;
    }
}