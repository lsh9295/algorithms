import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < K - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = K - 1; rt < N; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            System.out.print(map.size() + " ");
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0)
                map.remove(arr[lt]);
            lt++;
        }
    }
}