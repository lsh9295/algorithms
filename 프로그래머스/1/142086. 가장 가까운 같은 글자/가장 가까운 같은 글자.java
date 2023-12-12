class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String str = new String(sb); // 뒤집은 문자열 저장
        
        for (int i = 0; i < str.length(); i++) {
            char nowChar = str.charAt(i);
            String newStr = str.substring(i + 1, str.length());
            int result = newStr.indexOf(nowChar); // 자신을 제외한 가장 가까운 알파벳의 인덱스
            
            if (result != -1) // 자신과 같은 알파벳이 존재하면
                answer[str.length() - 1 - i] = result + 1;
            else // 자신 이외의 알파벳이 존재하지 않으면
                answer[str.length() - 1 - i] = result;
        }
        return answer;
    }
}
// 1. 문자열 뒤집기
// ananab 자기 자신 idx까지 제외하고 indexOf로 찾기 -> 배열에 추가