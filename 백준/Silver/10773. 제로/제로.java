import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                stack.pop();
            } else {
                stack.push(N);
            }
        }
        for (Integer n : stack) {
            sum += n;
        }
        System.out.println(sum);
    }
}