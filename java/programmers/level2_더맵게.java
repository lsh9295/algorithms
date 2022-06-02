
}import java.util.PriorityQueue;

class Solution {

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        int lowest_spicy;
        int low_spicy;

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.peek() < K) {
            lowest_spicy = queue.poll();
            if (!queue.isEmpty()) {
                low_spicy = queue.poll();
                queue.add(lowest_spicy + (low_spicy * 2));
                answer++;
            }
            if (queue.isEmpty())
                return (-1);
        }

        return (answer);
    }