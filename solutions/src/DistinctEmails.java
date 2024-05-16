import java.util.HashSet;

public class DistinctEmails {

    public static void main(String[] args) {
        // Case 1
        System.out.println(DistinctEmails.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));

        // Case 2
        System.out.println(DistinctEmails.numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));

        // Case 3
        System.out.println(DistinctEmails.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"}));
    }

    public static int numUniqueEmails(String[] emails) {
        int len = emails.length;
        if (len < 2) return len;
        HashSet<String> mails = new HashSet<>();
        for (String mail : emails) {
            StringBuilder sb = new StringBuilder();
            boolean ignoreRest = false;
            for (int i = 0; i < mail.length(); i++) {
                char c = mail.charAt(i);
                if (c == '@') {
                    sb.append(mail.substring(i));
                    break;
                } else if (c == '.') {
                    continue;
                } else if (c == '+') {
                    ignoreRest = true;
                } else {
                    if (!ignoreRest) {
                        sb.append(c);
                    }
                }
            }
            mails.add(sb.toString());
        }
        return mails.size();
    }
}
