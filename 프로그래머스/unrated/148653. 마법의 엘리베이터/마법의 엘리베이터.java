import java.util.Arrays;


class Solution {
     public static int solution(int buffer) {
        int cnt = 0;
        int storey = buffer;
        int unit = 0;
        int hund = 0;

        while (storey != 0) {
            unit = storey % 10;
            hund = (((storey % 100) - unit) / 10);

            if (hund >= 5 && unit >= 5) {
                cnt += (10 - unit);
                storey += unit;
            }
            else if (unit <= 5) {
                cnt += unit;
                storey -= unit;
            } else {
                cnt += (10 - unit);
                storey += unit;
            }
            storey /= 10;
        }
        return cnt;
    }
}
