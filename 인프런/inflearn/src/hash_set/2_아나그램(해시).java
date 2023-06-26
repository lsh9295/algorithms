import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String wordA = br.readLine();
        String wordB = br.readLine();

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (char x : wordA.toCharArray()) {
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        }

        for (char x : wordB.toCharArray()) {
            mapB.put(x, mapB.getOrDefault(x, 0) + 1);
        }

        if (mapA.size() != mapB.size()) { // 단어의 개수가 아예 다르면 예외처리
            System.out.println("NO");
        } else {
            for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
                if (!Objects.equals(entry.getValue(), mapB.get(entry.getKey()))) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }
}