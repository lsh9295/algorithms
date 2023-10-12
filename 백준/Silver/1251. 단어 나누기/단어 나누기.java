import java.util.*;
import java.io.*;

/** 풀이
 * 1. 세 개로 쪼개는 모든 케이스를 탐색 (아중 for문 substring)
 * 2. 쪼개진 문자열을 뒤집기
 * 3. 합치기
 * 4. ArrayList에 저장
 * 5. 모든 케이스를 앞글자 부터 탐색하되 ASCII의 숫자가 낮은 문자를 채택
 */
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] buffer = new String[3];
        ArrayList<String> strList = new ArrayList<>();

        for (int i = 1; i < str.length(); i++) { // 모든 분할 + reverse 케이스 탐색 및 저장
            for (int j = i + 1; j < str.length(); j++) {
                StringBuffer sb = new StringBuffer();

                buffer[0] = str.substring(0, i);
                buffer[0] = sb.append(buffer[0]).reverse().toString();
                sb = new StringBuffer();

                buffer[1] = str.substring(i, j);
                buffer[1] = sb.append(buffer[1]).reverse().toString();
                sb = new StringBuffer();

                buffer[2] = str.substring(j);
                buffer[2] = sb.append(buffer[2]).reverse().toString();
                sb = new StringBuffer();

                sb.append(buffer[0]).append(buffer[1]).append(buffer[2]);
                strList.add(sb.toString());
            }
        }
        Collections.sort(strList); // 컬렉션 오름차순 정렬
        System.out.println(strList.get(0));
    }
}