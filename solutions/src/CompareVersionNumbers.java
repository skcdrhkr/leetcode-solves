public class CompareVersionNumbers {
    public static void main(String[] args) {
        // Case 1
        System.out.println(CompareVersionNumbers.compareVersion("1.01", "1.001"));

        // Case 2
        System.out.println(CompareVersionNumbers.compareVersion("1.0", "1.0.0"));

        // Case 3
        System.out.println(CompareVersionNumbers.compareVersion("0.1", "1.1"));

        // Case 4
        System.out.println(CompareVersionNumbers.compareVersion("1", "1.0.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] first = version1.split("[.]");
        String[] second = version2.split("[.]");
        int indexA = 0, indexB = 0;
        int num1, num2;
        while (indexA < first.length || indexB < second.length) {
            num1 = (indexA >= first.length) ? 0 : Integer.parseInt(first[indexA]);
            num2 = (indexB >= second.length) ? 0 : Integer.parseInt(second[indexB]);
            if (num1 < num2) return -1;
            if (num2 < num1) return 1;
            indexA++;
            indexB++;
        }
        return 0;
    }
}
