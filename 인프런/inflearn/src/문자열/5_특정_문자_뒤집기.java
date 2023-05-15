import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] cList = str.toCharArray();
        int strLen = cList.length;
        int lp = 0;
        int rp = strLen - 1;

        while (lp <= rp) {
            if (Character.isAlphabetic(cList[lp]) && Character.isAlphabetic(cList[rp])) {
                char buffer = cList[lp];
                cList[lp] = cList[rp];
                cList[rp] = buffer;
                lp++;
                rp--;
                continue;
            }
            if (!Character.isAlphabetic(cList[lp]))
                lp++;

            if (!Character.isAlphabetic(cList[rp]))
                rp--;
        }

        for (char c : cList) {
            System.out.print(c);
        }
    }
}