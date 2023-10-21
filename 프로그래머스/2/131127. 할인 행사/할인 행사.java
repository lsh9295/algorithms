import java.util.*;

/**
* [문제]
* 1. 구매하고자 하는 물건은 총 10개
* 2. 구매하고자 하는 물건이 10일 연속으로 할인하는 case 탐색
****************************************************************
* [풀이법]
* 1. HashMap<물건, 개수> 선언
* 2. discount.length() - 10의 횟수만큼 탐색
* 3. discount의 물건이 사고자하는 물건과 일치하는 경우 물건개수 카운트 -= 1
* 4. map의 모든 카운트가 0인 케이스의 개수 return
*/

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            boolean isAnswer = true;
            
            for (int k = 0; k < want.length; k++) { // map 초기화
                map.put(want[k], number[k]);    
            }
            for (int j = i; j < 10 + i; j++) {
                if (map.get(discount[j]) != null)
                    map.put(discount[j], map.get(discount[j]) - 1);
                else
                    break;
            }
            for (String key : map.keySet()) {
                if (map.get(key) != 0) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer)
                answer++;
        }
        return answer;
    }
}