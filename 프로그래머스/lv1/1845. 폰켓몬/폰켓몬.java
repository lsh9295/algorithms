import java.util.HashSet;
import java.util.Set;

public class Solution {

	static int solution(int[] nums) {
		int answer;
		int maxKinds = nums.length / 2;
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if (maxKinds < set.size())
			return maxKinds;
		else {
			answer = set.size();
			return answer;
		}
	}
}