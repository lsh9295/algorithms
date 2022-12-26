import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int max;
        int lcm = 0; // 최소공배수
        int gcd = 0; // 최대공약수

        if (num1 >= num2)
            max = num1;
        else
            max = num2;

        int i = 0;
        while (max >= i) {
            i++;
            if (num1 % i == 0 && num2 % i == 0)
                lcm = i;
        }
        gcd = num1 * num2 / lcm;
        System.out.println(lcm + "\n" + gcd);
    }
}