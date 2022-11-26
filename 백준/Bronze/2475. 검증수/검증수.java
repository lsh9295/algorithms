import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];
        String[] numInput = br.readLine().split(" ");

        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(numInput[i]);
        }
        System.out.println(getVerifyNum(numbers));
    }
    private static int getVerifyNum(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += Math.pow(numbers[i], 2);
        }
        result %= 10;

        return result;
    }
}
