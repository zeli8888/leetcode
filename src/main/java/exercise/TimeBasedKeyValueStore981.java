package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 08/03/2025 12:16
 * @Version : V1.0
 * @Description :
 */
public class TimeBasedKeyValueStore981 {

}

class TimeMap {
    HashMap<String, ArrayList<String>> valMap = new HashMap<>();
    HashMap<String, ArrayList<Integer>> timeMap = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)){
            timeMap.put(key,new ArrayList<Integer>());
            valMap.put(key, new ArrayList<String>());
        }
        timeMap.get(key).add(timestamp);
        valMap.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        int targetIndex = -1;
        if (timeMap.containsKey(key)){
            ArrayList<Integer> timeList = timeMap.get(key);
            int left = 0;
            int right = timeList.size()-1;
            while (left <= right){
                int mid = left + (right-left)/2;
                int midTimestamp = timeList.get(mid);
                if (midTimestamp == timestamp){
                    return valMap.get(key).get(mid);
                }else if(midTimestamp < timestamp){
                    left = mid+1;
                    targetIndex = mid;
                }else{
                    right = mid-1;
                }
            }
        }
        if (targetIndex == -1){
            return "";
        }else{
            return valMap.get(key).get(targetIndex);
        }
    }
}