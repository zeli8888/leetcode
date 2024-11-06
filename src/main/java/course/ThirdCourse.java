package course;

import java.util.Hashtable;

/**
 * @Author : Ze Li
 * @Date : 06/11/2024 14:31
 * @Version : V1.0
 * @Description :
 */
public class ThirdCourse {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 3, 5, 6, 7, 9, 10};
        int target = 7;
        int found = ThirdCourse.binarySearch(nums, target);
        System.out.println("Found " + found);
    }

    public static void hashTable() {
        // hash table search with O(1) time complexity
        Hashtable<String, Integer> stringIntegerHashtable = new Hashtable<>();
        stringIntegerHashtable.put("apple", 10);
        stringIntegerHashtable.get("apple");
        stringIntegerHashtable.containsKey("apple");
        stringIntegerHashtable.containsValue(10);
        stringIntegerHashtable.remove("apple");
        stringIntegerHashtable.clear();
    }

    public static int binarySearch(int [] nums, int target) {
        // only works for sorted array
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                System.out.println(mid);
                return mid;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
