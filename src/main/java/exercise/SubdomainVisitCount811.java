package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 06/01/2025 13:35
 * @Version : V1.0
 * @Description :
 */
public class SubdomainVisitCount811 {
    public static void main(String[] args) {
        String[] codomains = {"9001 discuss.leetcode.com"};
        SubdomainVisitCount811 subdomainVisitCount811 = new SubdomainVisitCount811();
        System.out.println(subdomainVisitCount811.subdomainVisits(codomains));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String cpdomain : cpdomains) {
            int space = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, space));
            String domain = cpdomain.substring(space+1);
            map.merge(domain, count, Integer::sum);

            for(int i=0;i<domain.length();i++) {
                if(domain.charAt(i)=='.') {
                    String subdomain = domain.substring(i+1);
                    map.merge(subdomain, count, Integer::sum);
                }
            }
        }

        for(String subdomain: map.keySet()) {
            ans.add(map.get(subdomain)+" "+subdomain);
        }

        return ans;
    }

//    public List<String> subdomainVisits(String[] cpdomains) {
//        HashMap<String, Integer> domainCount = new HashMap<>();
//        for (String domain : cpdomains){
//            List<String> subDomainsWithCount = getSubDomainsWithCount(domain);
//            Iterator<String> iterator = subDomainsWithCount.iterator();
//            int count = Integer.parseInt(iterator.next());
//            while (iterator.hasNext()){
//                String subDomain = iterator.next();
//                if (!domainCount.containsKey(subDomain)){
//                    domainCount.put(subDomain, 0);
//                }
//                domainCount.put(subDomain, domainCount.get(subDomain)+count);
//            }
//        }
//        List<String> result = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : domainCount.entrySet()){
//            String domain = entry.getKey();
//            int count = entry.getValue();
//            result.add(count + " " + domain);
//        }
//        return result;
//    }
//
//    public List<String> getSubDomainsWithCount(String domain){
//        ArrayList<String> subDomains = new ArrayList<>();
//        String[] subStrings = domain.split("[\\. ]");
//        subDomains.add(subStrings[0]);
//        String subDomain = subStrings[subStrings.length-1];
//        subDomains.add(subDomain);
//        for (int i = subStrings.length-2; i > 0; i--){
//            String subString = subStrings[i];
//            subDomain = subString + "." + subDomain;
//            subDomains.add(subDomain);
//        }
//        return subDomains;
//    }
}
