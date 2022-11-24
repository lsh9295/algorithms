import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] subjects = new int[input]; // 입력받은 과목 점수 배열

        String[] subInput = br.readLine().split(" ");
        for (int i = 0; i < input; i++) {
            subjects[i] = Integer.parseInt(subInput[i]);
        }
        System.out.println(average(subjects));
    }
    private static double average(int[] subjects) {
        double aver;
        double max = 0;
        double sum = 0;

        // 가장 큰 점수 맥스값 초기화
        for (int i = 0; i < subjects.length; i++) {
            if (max < subjects[i])
                max = subjects[i];
        }

        for (int i = 0; i < subjects.length; i++) {
            sum = sum + (subjects[i] / max * 100);
        }
        aver = sum / subjects.length;

        return aver;
    }
}
