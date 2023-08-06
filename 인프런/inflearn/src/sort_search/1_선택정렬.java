import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[idx]) {
                    idx = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = tmp;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}