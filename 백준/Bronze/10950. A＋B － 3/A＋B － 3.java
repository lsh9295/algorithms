import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] numbers = new int[2];

            for (int j = 0; j < 2; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            calculate(numbers);
        }
    }

    private static void calculate(int[] numbers) {
        System.out.println(numbers[0] + numbers[1]);
    }
}