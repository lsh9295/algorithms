class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    public void dfs(int[] num, int target, int sum, int idx) {
        if(num.length <= idx) {
            if(sum == target)
                cnt++;
            return;
        }
        dfs(num, target, sum+num[idx], idx+1);
        dfs(num, target, sum-num[idx], idx+1);
    }
}