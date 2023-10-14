import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] cList = str.toCharArray();

        if (str.length() == 2) {
            if (cList[0] == cList[1]) {
                System.out.println(2);
                return;
            }
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (cList[i] == cList[str.length() - 1]) {
                for (int j = 1; j < str.length() / 2; j++) {
                    if (cList[i + j] == cList[str.length() - 1 - j]) {
                        if ((str.length() - 1 - j) - (i + j) <= 2) {
                            System.out.println(str.length() + i);

                            return;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (str.length() == 0)
            System.out.println(0);
        else
            System.out.println(str.length() * 2 - 1);
    }
}