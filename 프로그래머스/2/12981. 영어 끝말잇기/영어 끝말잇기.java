class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        for (int i = 0; i < words.length; i++) {
            if (i >= 1) {
                char last = words[i - 1].charAt(words[i - 1].length() - 1);
                char first = words[i].charAt(0);
                
                if (last != first) { // 끝말잇기 성립 불가 케이스
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    
                    return answer;
                }
            }
            
            for (int j = 0; j < i; j++) { // 중복 단어 확인 케이스
                if (words[i].equals(words[j])) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    
                    return answer;
                }
            }
        }
        return answer;
    }
}