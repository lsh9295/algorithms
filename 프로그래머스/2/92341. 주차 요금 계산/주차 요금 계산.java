import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inMap = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        List<String> sortList = new ArrayList();
            
        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            
            if (info[2].equals("IN")) {
                inMap.put(info[1], info[0]);    
            }
            
            if (info[2].equals("OUT")) {
                String[] outTime = info[0].split(":");
                String[] inTime = inMap.get(info[1]).split(":");
                 
                Integer outMinTime = (Integer.parseInt(outTime[0]) * 60) + Integer.parseInt(outTime[1]);
                Integer inMinTime = (Integer.parseInt(inTime[0]) * 60) + Integer.parseInt(inTime[1]);
                
                feeMap.put(info[1], feeMap.getOrDefault(info[1], 0) + outMinTime - inMinTime);
                inMap.remove(info[1]);
            }
        }
        
        if (!inMap.isEmpty()) { // 자정까지 남아있는 차 처리
            for (String key : inMap.keySet()) {
                String[] inTime = inMap.get(key).split(":");
            
                Integer outMinTime = 23 * 60 + 59;
                Integer inMinTime = (Integer.parseInt(inTime[0]) * 60) + Integer.parseInt(inTime[1]);
         
                feeMap.put(key, feeMap.getOrDefault(key, 0) + outMinTime - inMinTime); 
            }
        }
        int[] answer = new int[feeMap.size()];
        
        for (String key : feeMap.keySet()) 
            sortList.add(key);
        
        Collections.sort(sortList); // 차량번호가 낮은 순서대로 정렬

        for (int i = 0; i < answer.length; i++) {
            int entireFee = 0;
            int entireTime = feeMap.get(sortList.get(i));
            
            if (entireTime > fees[0]) {
                entireFee += fees[1];
                
                if ((entireTime - fees[0]) % fees[2] > 0) 
                    entireFee += (entireTime - fees[0]) / fees[2] * fees[3] + fees[3];
                else 
                    entireFee += (entireTime - fees[0]) / fees[2] * fees[3];
                
                answer[i] = entireFee;
            } else
                answer[i] = fees[1]; 
        }
        return answer;
    }
}

// [문제]
// 1. 입차 후 출차 내역이 없으면 23:59에 출차로 간주
// 2. 누적 주차 시간이 기본 시간 이하면 기본 요금 청구
// 3. 누적 주차 시간이 기본 시간을 초과하면 기본요금 + 단위시간 * N
// 4. 나누어 떨어지지 않으면 !!무조건!! 올림 처리
// 5. 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return

// [솔루션]
// 1. HashMap에 <차량번호, 입차시간>으로 저장
// 2. 해당 차량번호의 출차가 나오면 연산..