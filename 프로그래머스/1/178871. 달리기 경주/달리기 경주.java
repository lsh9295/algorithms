import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            
        }
        for (int i = 0; i < callings.length; i++) {
            int nowIdx = map.get(callings[i]);
            int beforeIdx = nowIdx - 1;
            
            String nowHuman = callings[i];
            String beforeHuman = players[beforeIdx];
            
            map.put(beforeHuman, map.get(beforeHuman) + 1);
            map.put(callings[i], map.get(callings[i]) - 1);
            
            answer[nowIdx] = beforeHuman;
            answer[beforeIdx] = nowHuman;
        }
        for (String key : map.keySet()) {
            int idx = map.get(key);
            answer[idx] = key;
        }
        return answer;
    }
}