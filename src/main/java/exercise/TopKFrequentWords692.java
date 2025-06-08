package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 08/06/2025 11:34
 * @Version : V1.0
 * @Description :
 */
public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ? a.compareTo(b) : Integer.compare(map.get(b), map.get(a)));
        pq.addAll(map.keySet());

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
