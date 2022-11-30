import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(remain42(nums));
    }

    private static int remain42(int[] nums) {
        int[] remainNums = new int[10];
        int result = 10;

        for (int i = 0; i < nums.length; i++) {
            remainNums[i] = nums[i] % 42;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (remainNums[i] == remainNums[j]) {
                    result--;
                    break;
                }
            }
        }
        return result;
    }
}
