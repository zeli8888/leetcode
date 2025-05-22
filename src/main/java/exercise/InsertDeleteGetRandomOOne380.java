package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * @Author : Ze Li
 * @Date : 22/05/2025 12:43
 * @Version : V1.0
 * @Description :
 */
public class InsertDeleteGetRandomOOne380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new InsertDeleteGetRandomOOne380().new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());

    }
    class RandomizedSet {
        ArrayList<Integer> list;
        HashMap<Integer , Integer> map;
        Random random = new Random();
        public RandomizedSet() {
            list = new ArrayList<>(200000);
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            map.put(val , list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            int ind = map.get(val);
            int lastInd  = list.get(list.size() - 1);

            list.set(ind , lastInd);
            map.put(lastInd , ind);
            list.remove(list.size() -1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
//        HashMap<Integer, Integer> map;
//        int[] array;
//        int size = -1;
//
//        public RandomizedSet() {
//            map = new HashMap<>();
//            array = new int[200000];
//        }
//
//        public boolean insert(int val) {
//            if (!map.containsKey(val)) {
//                map.put(val, ++size);
//                array[size] = val;
//                return true;
//            }
//            return false;
//        }
//
//        public boolean remove(int val) {
//            if (map.containsKey(val)) {
//                if (size != 0) {
//                    int index = map.get(val);
//                    int newVal = array[size];
//                    array[index] = newVal;
//                    map.put(newVal, index);
//                }
//                size--;
//                map.remove(val);
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        public int getRandom() {
//            return array[new Random().nextInt(size+1)];
//        }
    }
}