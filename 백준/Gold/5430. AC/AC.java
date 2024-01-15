import java.io.*;
import java.util.*;

/**
 * Baekjoon 5430 AC
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // TC

        for (int i = 0; i < T; i++) {
            String funcList = br.readLine(); // R or D String
            int size = Integer.parseInt(br.readLine());
            String strNumList = br.readLine();

            if (size == 0) { // 빈 배열 일때
                if (funcList.contains("D")) // 삭제가 있으면 에러
                    System.out.println("error");
                else                        // 삭제가 없이 R만 있으면 빈배열 리턴
                    System.out.println("[]");

                continue;
            }
            strNumList = strNumList.substring(1, strNumList.length() - 1);
            String[] splitNumList = strNumList.split(",");
            int[] numList = new int[splitNumList.length];

            for (int j = 0; j < numList.length; j++)
                numList[j] = Integer.parseInt(splitNumList[j]);

            numList = functionRD(funcList, numList);

            if (numList == null)
                continue;

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            for (int j : numList) {
                sb.append(j);
                sb.append(",");
            }
            if (numList.length > 0)
                sb.deleteCharAt(sb.length() - 1); // 마지막 쉼표 삭제

            sb.append("]");
            System.out.println(sb);

        }
    }

    public static int[] functionRD(String funcList, int[] numList) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean isLeft = true;

        for (int i : numList)
            deque.add(i);

        for (int i = 0; i < funcList.length(); i++) {
            if (funcList.charAt(i) == 'R')
                isLeft = !isLeft;

            if (funcList.charAt(i) == 'D') {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return null;
                }

                if (isLeft)
                    deque.removeFirst();
                else
                    deque.removeLast();
            }
        }
        int[] resultList = new int[deque.size()];

        for (int i = 0; i < resultList.length; i++) {
            if (isLeft) {
                resultList[i] = deque.pollFirst();
            } else {
                resultList[i] = deque.pollLast();
            }
        }
        return resultList;
    }
}