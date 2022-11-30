import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int nums = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int[] arr = new int[nums];

        for (int i = 0; i < nums; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        foundSmall(min, arr);
    }

    private static void foundSmall(int min, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                System.out.print(arr[i] + " ");
        }
    }
}
