import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = toBinaryMap(n, arr1);
        int[][] map2 = toBinaryMap(n, arr2);

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                if (map1[i][j] + map2[i][j] >= 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    public static int[][] toBinaryMap(int n, int[] arr) {
        int[][] map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            StringBuilder sb = new StringBuilder();
            
            if (binary.length() < n) { // 0으로 안 채워지는 경우 앞에 0으로 채우기    
                for (int j = 0; j < n - binary.length(); j++)
                    sb.append("0");    
            }
            sb.append(binary);
            binary = sb.toString();
            
            for (int k = 0; k < n; k++) {
                map[i][k] = binary.charAt(k) - '0';
            }
        }
        return map;
    }
}