import java.util.*;

class Solution {
    public int[] solution(String s) {
        String str = s.substring(2, s.length() - 2);
        String[] strList = str.split("\\},\\{");    
    
        for (int i = 0; i < strList.length; i++) { // 버블정렬 오름차순
            for (int j = i + 1; j < strList.length; j++) {
                if (strList[i].length() > strList[j].length()) {
                    String buffer = strList[i];
                    strList[i] = strList[j];
                    strList[j] = buffer;
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[strList.length]; // a1은 무조건 고정
        
        for (int i = 0; i < strList.length; i++) {
            String[] subStr = strList[i].split(",");
            
            for (int j = 0; j < subStr.length; j++) {
                map.put(Integer.parseInt(subStr[j]), map.getOrDefault(Integer.parseInt(subStr[j]), 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() == 1) {
                    answer[i] = pair.getKey();
                }
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }
}