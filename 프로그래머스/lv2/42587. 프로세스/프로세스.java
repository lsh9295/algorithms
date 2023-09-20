import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public static int solution(int[] priorities, int location) {

		PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
		int answer = 1;

		for (int i = 0; i < priorities.length; i++) {
			que.add(priorities[i]);
		}
		while (!que.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == que.peek()) {
					if (location == i)
						return answer;
					answer++;
					que.poll();
				}
			}
		}
		return answer;
	}
}