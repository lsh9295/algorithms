import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0)
                break;
            if (isPalindrome(num))
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }
    public static boolean isPalindrome(int num) {
        int div = num / 10;
        int a = 0; // 만의 자리
        int b = 0; // 천의 자리
        int c = 0; // 백의 자리
        int d = 0; // 십의 자리
        int e = 0; // 일의 자리

        if (div == 0) { // 1의 자리는 무조건 펠린드롬
            return true;
        } else if (div > 0 && div < 10) { // 10 이상
            d = num / 10;
            e = num % 10;

            if (d == e)
                return true;
            else
                return false;
        } else if (div > 9 && div < 100) { // 100 이상
            c = num / 100;
            e = num % 10;

            if (c == e)
                return true;
            else
                return false;
        } else if (div > 99 && div < 1000) { // 1000 이상
            b = num / 1000;
            c = (num % 1000) / 100;
            d = (num % 100) / 10;
            e = num % 10;

            if (b == e && c == d)
                return true;
            else
                return false;
        } else if (div > 999 && div < 10000) { // 10000 이상
            a = num / 10000;
            b = (num % 10000) / 1000;
            d = (num % 100) / 10;
            e = num % 10;

            if (a == e && b == d)
                return true;
            else
                return false;
        }
        return false;
    }
}
