import java.util.*;

class Solution {
    static List<String> cityList = new LinkedList<>(); // 캐싱 DB
    static int time = 0; // 실행시간
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5; // 캐시 사이즈가 0이면 모든 도시가 캐시 miss로 처리됨

        for (String cityUpper : cities) {
            String city = cityUpper.toLowerCase();

            if (cityList.contains(city)) { // 캐시 hit
                cityList.remove(city);
                cityList.add(city); // 인덱스 업데이트
                
                time += 1;
            } else { // 캐시 miss
                if (cityList.size() >= cacheSize) // 캐시 사이즈를 넘으면 LRU 교체
                    cityList.remove(0);
                
                cityList.add(city);
                time += 5;
            }
        }
        return time;
    }
}
