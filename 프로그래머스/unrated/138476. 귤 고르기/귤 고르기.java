import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int K = k;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] counts = new int[map.size()];
        int idx = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            counts[idx] = entry.getValue();
            idx++;
        }
        Arrays.sort(counts);
        idx = counts.length - 1;
        
        while(K > 0) {
            K -= counts[idx];
            idx--;
            answer++;
        }
        
        return answer;
    }
}