import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) // 단어 입력
            input[i] = br.readLine();

        for (String word: input) { // 단어 리스트 중복 제거 후 초기화
            if (!words.contains(word))
                words.add(word);
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length())
                    return s1.compareTo(s2);
                else
                    return s1.length() - s2.length();
            }
        };
        words.sort(c);

        for (String s : words) {
            System.out.println(s);
        }
    }
}
