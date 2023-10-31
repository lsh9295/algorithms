import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            char[] cList = keymap[i].toCharArray();
            
            for (int j = 0; j < cList.length; j++) {
                if (map.get(cList[j]) == null) {
                    map.put(cList[j], j + 1);    
                } else {
                    if (map.get(cList[j]) > j + 1) {
                        map.put(cList[j], j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < targets.length; i++) {
            char[] cList = targets[i].toCharArray();
            int sum = 0;
            
            for (int j = 0; j < cList.length; j++) {
                if (map.get(cList[j]) == null) {
                    answer[i] = -1;
                    break;
                }
                sum += map.get(cList[j]);
            }
            if (answer[i] == -1)
                continue;
            
            answer[i] = sum;
        }
        return answer;
    }
}
/*
map에다가 알파벳과 가중치를 입력
만약 같은 알파벳이 있으면 더 작은걸로 map에 저장
map에서 찾을 수 없으면 return -1
*/