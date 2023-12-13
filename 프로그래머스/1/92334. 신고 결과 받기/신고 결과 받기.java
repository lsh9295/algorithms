import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] answers = new int[id_list.length];
        String[] reports = Arrays.stream(report).distinct().toArray(String[]::new);
        Map<String, Integer> reportCntMap = new HashMap<>();
        Map<String, ArrayList<String>> userReportList = new LinkedHashMap<>(); // id_list의 순서를 보장하기 위한 LinkedHashMap

        for (String id : id_list) { // 신고 카운트 맵 0 초기화
            reportCntMap.put(id, 0);
        }
        for (String id : id_list) { // 신고 리스트 맵 초기화
            userReportList.put(id, new ArrayList<>());
        }
        for (String r : reports) {
            String[] contents = r.split(" "); // "신고자 피신고자"
            reportCntMap.put(contents[1], reportCntMap.get(contents[1]) + 1); // 누적 신고 카운트 증가
            ArrayList<String> reportList = userReportList.getOrDefault(contents[0], new ArrayList<>());

            reportList.add(contents[1]);
            userReportList.put(contents[0], reportList);
        }
        for (Map.Entry<String, ArrayList<String>> map : userReportList.entrySet()) { // 신고 리스트 순회
            ArrayList<String> reportArray = map.getValue();
            int totalCnt = 0;

            for (String ra : reportArray) {
                int cnt = reportCntMap.get(ra);

                if (cnt >= k) {
                    totalCnt++;
                }
            }
            answer.add(totalCnt);
        }
        for (int i = 0; i < id_list.length; i++) {
            answers[i] = answer.get(i);
        }
        return answers;
    }
}