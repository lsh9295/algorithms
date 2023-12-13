import java.util.*;


// 2. number -> 24 - 1, 2, 3, 4, 6, 8, 12, 24
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1; // 1은 항상 포함
        
        for (int i = 2; i <= number; i++) {           
            int max = i;
            int cMax = max;
            int cnt = 2; // 1과 자기 자신(max)은 항상 포함
            
            for (int j = 2; j < max; j++) {
                if (cMax % j == 0) { // 약수란 소리
                    max = cMax / j;
                    
                    if (j == max)
                        cnt++;
                    else
                        cnt += 2;
                }
                
                if (cnt > limit) {
                    answer += power;
                    break;
                }
            }
            
            if (cnt <= limit) {
                answer += cnt;
            }
        }
        return answer;
    }
}

/*
[풀이법]
1. 1 ~ number 까지 각각의 약수를 구해 배열에 저장
2. limit를 넘는 약수가 존재하는지 판별
3. limit를 넘으면 모두 power로 계산
4. 모든 약수의 개수를 더해서 정답 반환

1을 구하면 자동으로 max값 추가
2를 구하면 자동으로 max / 2 값 추가, 해당 값 max로 설정
3을 구하면 자동으로 max / 3 값 추가, 해당 값 max로 설정
4를 구하면 자동으로 max / 4 값 추가

만약 j가 number / j 랑 같으면 추가하지 않음 // ex) 3 * 3

[TC]
-1. number -> 4 - 1, 2, 4
0. number -> 10 - 1, 2, 5, 10
1. number -> 12 - 1, 2, 3, 4, 6, 12
2. number -> 24 - 1, 2, 3, 4, 6, 8, 12, 24
3. number -> 21 - 1, 3, 7, 21
4. number -> 42 -> 1, 2, 3, 6, 7, 14, 21, 42
*/