import java.util.*;

class Solution {
    static int cTarget = 0;
    static int cnt = 0;

    public static int solution(int[] numbers, int target) {
        cTarget = target;
        dfs(0, 0, numbers);

        return cnt;
    }

    public static void dfs(int level, int sum, int[] numbers) {
        if (level == numbers.length) {
            if (sum == cTarget)
                cnt++;
        } else {
            dfs(level + 1, sum + numbers[level], numbers);
            dfs(level + 1, sum - numbers[level], numbers);
        }
    }
}