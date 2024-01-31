class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int startIdx = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            
            for (int j = startIdx; j <= k + i; j++) {
                int num = number.charAt(j) - '0';
                
                if (num > max) {
                    max = num;
                    startIdx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}