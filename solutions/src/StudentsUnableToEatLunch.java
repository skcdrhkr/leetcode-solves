public class StudentsUnableToEatLunch {

    public static void main(String[] args) {
        // Case 1
        System.out.println(StudentsUnableToEatLunch.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));

        // Case 2
        System.out.println(StudentsUnableToEatLunch.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int ones = 0, zeroes = 0;
        for (int std : students) {
            if (std == 1) ones++;
            else zeroes++;
        }
        int sands = 0, i = 0;
        for (i = 0; i < n; i++) {
            sands = sandwiches[i];
            if (sands == 1) {
                if (ones > 0) {
                    ones--;
                } else {
                    break;
                }
            } else {
                if (zeroes > 0) zeroes--;
                else break;
            }
        }
        return n - i;
    }
}
