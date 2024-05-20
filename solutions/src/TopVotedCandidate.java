public class TopVotedCandidate {

    int size;
    private int[] voteCounts;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        int len = persons.length;
        size = len;
        int[] hash = new int[len];
        voteCounts = new int[len];
        this.times = times;
        int mx;
        voteCounts[0] = persons[0];
        hash[persons[0]] = 1;
        mx = persons[0];
        for (int i = 1; i < len; i++) {
            hash[persons[i]]++;
            if (hash[persons[i]] >= hash[mx]) {
                mx = persons[i];
                voteCounts[i] = persons[i];
            } else {
                voteCounts[i] = mx;
            }
        }
    }

    public static void main(String[] args) {
        // Case 1
        TopVotedCandidate votedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(votedCandidate.q(3));
        System.out.println(votedCandidate.q(12));
        System.out.println(votedCandidate.q(25));
        System.out.println(votedCandidate.q(15));
        System.out.println(votedCandidate.q(24));
        System.out.println(votedCandidate.q(8));
    }

    public int q(int t) {
        if (t >= times[size - 1]) return voteCounts[size - 1];
        int lo = 0, hi = size - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo + 1) / 2;
            if (times[mid] > t) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return voteCounts[lo];
    }
}
