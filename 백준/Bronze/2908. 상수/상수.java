import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        getBigNum(num1, num2);
    }
    private static void getBigNum(int num1, int num2) {
        int revNum1 = reverseNum(num1);
        int revNum2 = reverseNum(num2);
        
        if (revNum1 > revNum2)
            System.out.println(revNum1);
        else
            System.out.println(revNum2);
    }

    private static int reverseNum(int num){
        int buffer = num;
        int changed = 0;

        changed += (buffer / 100);
        buffer %= 100;

        changed += (buffer / 10 * 10);
        buffer %= 10;

        changed += (buffer * 100);

        return changed;
    }
}
