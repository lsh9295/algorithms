import java.util.Arrays;

class Solution {
		public static int solution(int[] people, int limit) {
		int answer = 0;
		int start_idx = 0;
		int end_idx = people.length - 1;
		Arrays.sort(people);
		while (start_idx <= end_idx) {
			
			if (people[start_idx] + people[end_idx] <= limit) {
				start_idx++;
				end_idx--;
				answer++;
			} else {
				answer++;
				end_idx--;
			}
		}
		return answer;
	}
}