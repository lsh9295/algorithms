class Solution {
    public static int[] solution(int N, int[] stages) {

        double[] failure = new double[N];
        int[] answer = new int[N];
        int entire;
        int non_clear;
        double temp;

        for (int i = 1; i <= N; i++) { // 1 2 3 4 5 entire , non_clear 구하기

            entire = 0;
            non_clear = 0;
            temp = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j])
                    entire++;
                if (i == stages[j])
                    non_clear++;
            }
            if (non_clear == 0) {
                failure[i - 1] = 0;
                continue;
            }
            failure[i - 1] = (double) non_clear / (double) entire;
        }
        for (int i = 0; i < failure.length; i++) {
            double max = -1;
            int maxIdx = 0;

            for (int j = 0; j < failure.length; j++) {
                if (max < failure[j]) {

                    max = failure[j];
                    maxIdx = j;
                }
            }
            failure[maxIdx] = -1;
            answer[i] = maxIdx + 1;
        }
        return answer;
    }
}