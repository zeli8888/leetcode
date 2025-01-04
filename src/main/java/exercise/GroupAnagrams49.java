package exercise;

import java.util.*;


/**
 * @Author : Ze Li
 * @Date : 04/01/2025 15:03
 * @Version : V1.0
 * @Description :
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = new String[] {"",""};
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        System.out.println(groupAnagrams49.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, List<String>> dict = new Hashtable<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedStr = new String(array);
            if (dict.containsKey(sortedStr)){
                dict.get(sortedStr).add(str);
            } else{
                List<String> initList = new LinkedList<>();
                initList.add(str);
                dict.put(sortedStr, initList);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (List l : dict.values()){
            List list = new LinkedList(l);
            result.add(list);
        }
        return result;
    }
}
