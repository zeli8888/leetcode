package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 04/12/2024 16:21
 * @Version : V1.0
 * @Description :
 */
public class MinimumGeneticMutation433 {
    public static void main(String[] args) {
        String startGene = "AAAAAAAA";
        String endGene = "CCCCCCCC";
        String[] bank = {
                "AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"
        };
        System.out.println(new MinimumGeneticMutation433().minMutation(startGene, endGene, bank));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q=new LinkedList<>(); //

        HashSet<String> vis=new HashSet<>(); //Storing visited nodes

        q.add(startGene);
        vis.add(startGene);
        int count=0; //Levels of the graph/tree

        while(!q.isEmpty()){
            int size=q.size(); //BFS
            for(int i=0;i<size;i++){
                String s=q.poll();

                if(s.equals(endGene)){
                    return count;
                }

                for(String b: bank){
                    if(vis.contains(b) || !isValidMutation(s, b)){
                        continue;
                    }

                    q.add(b);
                    vis.add(b);

                }
            }
            count++; //Incrasing the count/level
        }
        return -1;
    }

    //If there is diff of only 1 char then its a valid mitstion from source
    private boolean isValidMutation(String a , String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>1){
                    return false;
                }
            }

        }
        return diff==1;
    }

//    public int minMutation(String startGene, String endGene, String[] bank) {
//        Queue<Object[]> genes = new LinkedList<>();
//        genes.add(new Object[]{startGene, 0});
//        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
//        while (!genes.isEmpty()){
//            Object[] addedGenePair = genes.poll();
//            String addedGene = (String) addedGenePair[0];
//            int numMutes = (int) addedGenePair[1];
//            if (Objects.equals(addedGene, endGene)) return numMutes;
//            ArrayList<Object> toRemove = new ArrayList<>();
//            for (String gene : bankSet) {
//                if (findDiffs(gene, addedGene) == 1) {
//                    toRemove.add(gene);
//                    genes.add(new Object[]{gene, numMutes + 1});
//                }
//            }
//            for (Object gene : toRemove){
//                bankSet.remove(gene);
//            }
//        }
//        return -1;
//    }
//
//    public int findDiffs(String gene1, String gene2){
//        int num = 0;
//        for (int i = 0; i<gene1.length(); i++){
//            if (gene1.charAt(i) != gene2.charAt(i)){
//                num++;
//            }
//        }
//        return num;
//    }
}
