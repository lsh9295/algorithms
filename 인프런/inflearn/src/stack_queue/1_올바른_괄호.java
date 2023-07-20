import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (stack.empty()) {
                stack.add(c);
            }
            else {
                char popC = stack.peek();

                if (popC == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        if (stack.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}