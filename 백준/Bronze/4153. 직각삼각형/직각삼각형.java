import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int max = 0;
            
            if (num1 == 0 && num2 == 0 && num3 == 0)
                break;
            
            if (num1 >= num2)
                if (num1 >= num3) {
                    max = num1;
                    calculate(max, num2, num3);
                }
                else {
                    max = num3;
                    calculate(max, num2, num1);
                }
            else {
                if (num2 >= num3) {
                    max = num2;
                    calculate(max, num1, num3);
                }
                else {
                    max = num3;
                    calculate(max, num2, num1);
                }
            }
        }

    }
    public static void calculate(int max, int n, int m) {
        if ((pow(n, 2) + pow(m, 2)) == pow(max,2))
            System.out.println("right");
        else
            System.out.println("wrong");
    }
}