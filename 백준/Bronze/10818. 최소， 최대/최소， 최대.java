import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numbers = new int[input];

        for (int i = 0; i < input; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
       minMax(numbers);
    }

    private static void minMax(int[] numbers) {
        int min = 1000000;
        int max = -1000000;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= min) {
                min = numbers[i];
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= max) {
                max = numbers[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
