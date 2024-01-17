import java.io.*;
import java.util.*;

/**
 * Baekjoon 27866 문자와 문자열
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int idx = Integer.parseInt(br.readLine());

        System.out.println(str.charAt(idx - 1));
    }
}