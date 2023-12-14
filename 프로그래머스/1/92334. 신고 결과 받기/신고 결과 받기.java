import java.util.*;

class Solution {
    static int[] answer;
    
    public static int[] solution(String[] id_list, String[] report, int k) {
        answer = new int[id_list.length];
        Map<String, Integer> map = new LinkedHashMap<>(); // 유저별 피신고 횟수
        Map<String, Integer> answerMap = new LinkedHashMap<>(); // 유저별 메일을 받은 횟수]
        Map<String, Integer> lastMap = new LinkedHashMap<>();
        
        Set<String> set = new HashSet<>(); // 신고 내역
        
        for (int i = 0; i < report.length; i++) // 신고 내역 중복 제거 프로세스
            set.add(report[i]); 
        
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
            answerMap.put(id_list[i], 0);
            lastMap.put(id_list[i], 0);
        }
        
        for (String s : set) {
            String[] reportContent = s.split(" ");
            String toReport = reportContent[0]; // 신고자
            String fromReport = reportContent[1]; // 피신고자
            
            map.put(fromReport, map.get(fromReport) + 1);
        }
        
        for (String s : set) {
            String[] reportContent = s.split(" ");
            String toReport = reportContent[0];
            String fromReport = reportContent[1];
            
            if (map.get(fromReport) >= k)
                answerMap.put(toReport, answerMap.get(toReport) + 1);
        }
        System.out.println(answerMap);
        
        for (int i = 0; i < id_list.length; i++) // 순서 변환
            lastMap.put(id_list[i], answerMap.get(id_list[i]));
        
        for (int i = 0; i < id_list.length; i++) 
            answer[i] = lastMap.get(id_list[i]);
        
        System.out.println(lastMap);
    
        return answer;
    }
}

/*
[풀이법]
1. 각 유저는 한 번에 한 명의 유저를 신고 가능
2. 동일한 유저 신고는 1회로 처리
3. k번 이상 신고된 유저는 게시판 이용이 정지
4. return은 유저가 받은 자신이 신고한 유저의 정지 여부

[Tip]
LinkedHashMap을 사용하여 순서를 유지하며 신고 횟수 카운팅
동일한 유저 신고 처리는 HashSet으로 중복 제거

*/