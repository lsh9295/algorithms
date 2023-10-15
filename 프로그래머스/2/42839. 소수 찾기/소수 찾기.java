import java.util.*;

class Solution {
    static int answer = 0;
    static HashSet<Integer> set = new HashSet<>();
    static char[] chars;
    static boolean[] visited;
    
    public int solution(String numbers) {
        chars = numbers.toCharArray();
        visited = new boolean[chars.length];
        
        DFS("", 0);
        
        answer = set.size();
        
        return answer;
    }
    
    public static void DFS(String str, int L) {
        if (!str.equals("")) {
            int num = Integer.parseInt(str);
            
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        if (L == chars.length) return;
        
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue; 
                
            visited[i] = true; 
            DFS(str + chars[i], L + 1); 
            visited[i] = false;
        }
    }
    
    public static boolean isPrime(int num) {
    // 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int)Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}