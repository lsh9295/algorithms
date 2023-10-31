class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] isPaint = new boolean[n];
        
        for (int i = 0; i < section.length; i++) {
            isPaint[section[i] - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            if (isPaint[i] == true) {
                answer++;
                i += (m - 1);
            }
        }
        return answer;
    }
}