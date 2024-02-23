import java.util.Arrays;

public class Bowling {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Bowling.calcScore("134452X-/-1X2/--36"));

        // Case 2
        System.out.println(Bowling.calcScore("X9/5/72XXX9-8/9/"));

        // Case 3
        System.out.println(Bowling.calcScore("8/549-XX5/53639/9/"));
    }

    private static int calcScore(String game) {
        char[] input = game.toCharArray();
        int[] frames = new int[10];
        int ind = 9;
        for (int i = input.length - 1; i >= 0; i -= 2) {
            if (input[i] == 'X') {
                frames[ind] = 10;
                if (i < input.length - 1) {
                    if (input[i + 1] == 'X') {
                        frames[ind] += 10;
                        if (i < input.length - 2) {
                            if (input[i + 2] == 'X')
                                frames[ind] += 10;
                            else if (input[i + 2] != '-')
                                frames[ind] += (input[i + 2] - '0');
                        }
                    } else if (input[i + 1] != '-') {
                        if (input[i + 2] == '/')
                            frames[ind] += 10;
                        else {
                            frames[ind] += (input[i + 1] - '0');
                            if (input[i + 2] != '-')
                                frames[ind] += (input[i + 2] - '0');
                        }
                    } else if (input[i + 1] == '-') {
                        if (input[i + 2] == '/')
                            frames[ind] += 10;
                        else {
                            if (input[i + 2] != '-')
                                frames[ind] += (input[i + 2] - '0');
                        }
                    }
                }
                i += 1;
            } else if (input[i] == '/') {
                frames[ind] = 10;
                if (i < input.length - 1) {
                    if (input[i + 1] == 'X')
                        frames[ind] += 10;
                    else if (input[i + 1] != '-')
                        frames[ind] += (input[i + 1] - '0');
                }
            } else if (input[i] == '-') {
                if (input[i - 1] != '-') {
                    frames[ind] = input[i - 1] - '0';
                }
            } else {
                frames[ind] = input[i] - '0';
                if (input[i - 1] != '-') {
                    frames[ind] += input[i - 1] - '0';
                }
            }
            ind -= 1;
        }
        return Arrays.stream(frames).sum();
    }
}
