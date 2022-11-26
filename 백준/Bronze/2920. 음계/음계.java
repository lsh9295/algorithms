import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[8];
        String[] numInput = br.readLine().split(" ");

        for (int i = 0; i < 8; i++) {
            numbers[i] = Integer.parseInt(numInput[i]);
        }
        System.out.println(scaleDiscriminate(numbers));
    }

    private static String scaleDiscriminate(int[] scale) {
        if (scale[0] == 1) {
            for (int i = 0; i < 7; i++) {
                if (scale[i] + 1 != scale[i + 1]) {
                    return "mixed";
                }
            }
            return "ascending";
        } else if (scale[0] == 8) {
            for (int i = 0; i < 7; i++) {
                if (scale[i] - 1 != scale[i + 1]) {
                    return "mixed";
                }
            }
            return "descending";
        } else {
            return "mixed";
        }
    }
}
