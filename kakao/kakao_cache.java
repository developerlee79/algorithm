package kakao;

import java.util.LinkedHashMap;

public class kakao_cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] citiesArr = {"jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(getCacheRunningTime(cacheSize, citiesArr));
    }

    static int getCacheRunningTime(int cacheSize, String[] cities) {
        int totalTime = 0;

        if (cacheSize == 0) return cities.length * 5;

        LinkedHashMap<String, Integer> lurMap = new LinkedHashMap<String, Integer>() {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<String, Integer> eldest) {
                return cacheSize > 0 && size() > cacheSize;
            }
        };

        for (String key : cities) {
            if (lurMap.containsKey(key.toUpperCase())) {
                totalTime += 1;
            } else {
                lurMap.put(key.toUpperCase(), 1);
                totalTime += 5;
            }
        }

        return totalTime;
    }
}
