package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 24/06/2025 11:06
 * @Version : V1.0
 * @Description :
 */
public class InsertDeleteGetRandomOOneDuplicatesAllowed381 {
    class RandomizedCollection {
        HashMap<Integer, Set<Integer>> valIndexesMap;
        ArrayList<Integer> valList;
        Random random = new Random();
        public RandomizedCollection() {
            this.valIndexesMap = new HashMap<>();
            this.valList = new ArrayList<>();
        }

        public boolean insert(int val) {
            boolean ans = !valIndexesMap.containsKey(val);
            if (ans) valIndexesMap.put(val, new HashSet<>());
            valIndexesMap.get(val).add(valList.size());
            valList.add(val);
            return ans;
        }

        public boolean remove(int val) {
            if (!valIndexesMap.containsKey(val)) return false;
            Set<Integer> indexes =  valIndexesMap.get(val);
            Integer indexToDelete = indexes.iterator().next();
            indexes.remove(indexToDelete);
            if (indexes.isEmpty()) valIndexesMap.remove(val);
            int lastIndex = valList.size()-1;
            if (indexToDelete != lastIndex) {
                int lastVal = valList.get(lastIndex);
                Set<Integer> lastValIndexes = valIndexesMap.get(lastVal);
                lastValIndexes.remove(lastIndex);
                lastValIndexes.add(indexToDelete);
                valList.set(indexToDelete, lastVal);
            }
            valList.remove(lastIndex);
            return true;
        }

        public int getRandom() {
            return valList.get(random.nextInt(valList.size()));
        }
    }
}
