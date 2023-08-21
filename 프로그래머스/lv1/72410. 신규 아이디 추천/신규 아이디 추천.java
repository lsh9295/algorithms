/* - 아이디 규칙 -
* 1. id는 3자 이상 15자 이하
* 2. id는 소문자, 숫자, -, _, . 로만 구성가능
* 3. .(마침표)는 처음과 끝에 사용 불가 + 연속 사용 불가
* if 규칙에 맞지 않는 아이디는 7단계에 거쳐 아이디를 추천해줌 
*/
import java.util.*;

class Solution {
    public static String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        char[] cArr = new_id.toCharArray();
        ArrayList<Character> cList = new ArrayList<>();

        // 1단계 (대문자 -> 소문자 치환)
        for (int i = 0; i < cArr.length; i++)
            if (cArr[i] >= 'A' && cArr[i] <= 'Z')
                cArr[i] += 32;

        // 2단계 (숫자, 소문자, 빼기, 밑줄, 마침표 제외 문자 제거)
        for (char c : cArr)
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || c == '-'
                    || c == '.' || c == '_')
                cList.add(c);

        // 3단계 마침표가 연속(...)인 경우 (.) 하나로 치환
        for (int i = 1; i < cList.size(); i++) {
            if (cList.get(i) == '.' && cList.get(i - 1) == '.') {
                cList.remove(i);
                i--; // 현재 인덱스를 하나 줄여서 중복 검사를 위해 다시 검사
            }
        }

        // 4단계 첫 번째, 끝 마침표(.) 제거
        if (!cList.isEmpty() && cList.get(cList.size() - 1) == '.')
            cList.remove(cList.size() - 1);

        if (!cList.isEmpty() && cList.get(0) == '.')
            cList.remove(0);

        // 5단계 빈 문자열 a 대입
        if (cList.isEmpty())
            cList.add('a');

        // 6단계 길이 제한 16자
        if (cList.size() > 15) {
            for (int i = 15; i < cList.size(); i++) {
                cList.remove(i);
                i--;
            }
            
            if (cList.get(cList.size() - 1) == '.')
                cList.remove(cList.size() - 1);
        }

        // 7단계
        if (cList.size() <= 2) {
            while (cList.size() < 3) {
                cList.add(cList.get(cList.size() - 1));
            }
        }

        for (char c : cList) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}