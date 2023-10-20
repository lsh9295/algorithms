import java.util.*;
/**
 * 1. 세로의 길이는 무조건 2 / 가로의 길이는 n
 * 2. 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
 * 
 * ex) 2 2 / 1 1 1 1 / 2 1 1 / 1 2 1 / 1 1 2
 */


class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;;
        }
        
        answer = dp[n];
        
        return answer;
    }
}