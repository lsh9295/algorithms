import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println(getLeapYear(input));
    }

    private static int getLeapYear(int input) {
        int result = 0;

        if (input % 4 == 0) {
            if (input % 100 != 0 || input % 400 == 0) {
                result = 1;
            }
        }
        
        return result;
    }
}
