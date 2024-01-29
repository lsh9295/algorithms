import java.util.*;

public class Solution {  
    public int solution(int n) {
        int N = n;
        int jump = 0;
        
        if (N == 1)
            return 1;
        
        while (N > 0) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N--;
                jump++;
            }
        }
        return jump;
    }
}

// k칸 점프  or  지금까지 온 거리 x 2
// (건전지 소모 0) (건전지 소모 x)
