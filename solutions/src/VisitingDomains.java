import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitingDomains {

    public static void main(String[] args) {
        // Case 1
        System.out.println(VisitingDomains.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));

        // Case 2
        System.out.println(VisitingDomains.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visCount = new HashMap<>();
        for (String domain : cpdomains) {
            String[] pair = domain.split(" ");
            Integer count = Integer.parseInt(pair[0]);
            String curDomain = pair[1];

            while (!curDomain.isEmpty()) {
                visCount.put(curDomain, visCount.getOrDefault(curDomain, 0) + count);
                int ind = curDomain.indexOf('.');
                if (ind == -1) break;
                curDomain = curDomain.substring(ind + 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : visCount.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
