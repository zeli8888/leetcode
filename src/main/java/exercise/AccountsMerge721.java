package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 28/03/2025 13:33
 * @Version : V1.0
 * @Description :
 */
public class AccountsMerge721 {
    private class UnionFound {
        int[] parent;
        int[] weight;

        public UnionFound (int num) {
            parent = new int[num];
            weight = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);
            if (rootA == rootB) {
                return;
            }
            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            }else {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            }
        }

        public int root(int a) {
            if (parent[a] == a) {
                return a;
            }
            return parent[a]=root(parent[a]);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailToId = new HashMap<>();
        UnionFound uf = new UnionFound(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                }else {
                    uf.union(i, emailToId.get(email));
                }
            }
        }

        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = uf.root(emailToId.get(email));
            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<>());
            }
            idToEmails.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Integer id : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            ans.add(emails);
        }
        return ans;
    }
}
