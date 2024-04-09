import java.util.*;

public class EmployeeFreeTime {

    public static void main(String[] args) {
        // Case 1
        System.out.println(EmployeeFreeTime.employeeFreeTime(List.of(List.of(new Interval(1, 2), new Interval(5, 6)), List.of(new Interval(1, 3)), List.of(new Interval(4, 10)))));

        // Case 2
        System.out.println(EmployeeFreeTime.employeeFreeTime(List.of(List.of(new Interval(1, 3), new Interval(6, 7)), List.of(new Interval(2, 4)), List.of(new Interval(2, 5), new Interval(9, 12)))));

        // Case 3
        System.out.println(EmployeeFreeTime.employeeFreeTime(List.of(List.of(new Interval(2, 3), new Interval(7, 9)), List.of(new Interval(1, 4), new Interval(6, 7)))));

        // Case 4
        System.out.println(EmployeeFreeTime.employeeFreeTime(List.of(List.of(new Interval(3, 5), new Interval(8, 10)), List.of(new Interval(4, 6), new Interval(9, 12)), List.of(new Interval(5, 6), new Interval(8, 10)))));

    }

    public static List<Interval> employeeFreeTimeIntersectFreeTime(List<List<Interval>> input) {

        List<List<Interval>> schedule = new LinkedList<>();
        for (List<Interval> sch : input) {
            schedule.add(new LinkedList<>(sch));
        }
        List<Interval> ans = new ArrayList<>();
        int len = schedule.size();
        // Add new Interval of -2 -> first meeting start time to each employee schedule
        for (List<Interval> sch : schedule) {
            sch.add(0, new Interval(-2, sch.get(0).start));
        }
        // We find the intersection of free time
        boolean freeTimeRemaining = true;
        while (freeTimeRemaining) {
            int newStart = Integer.MIN_VALUE;
            int newEnd = Integer.MAX_VALUE;
            for (List<Interval> sch : schedule) {
                newStart = Math.max(newStart, sch.get(0).start);
                newEnd = Math.min(newEnd, sch.get(0).end);
            }
            if (newEnd == Integer.MAX_VALUE) break;
            if (newStart < newEnd) {
                ans.add(new Interval(newStart, newEnd));
            }
            for (List<Interval> sch : schedule) {
                if (sch.get(0).end == newEnd) {
                    sch.remove(0);
                    Interval lastMeet = sch.remove(0);
                    int newFreeEnd;
                    if (sch.isEmpty()) newFreeEnd = Integer.MAX_VALUE;
                    else newFreeEnd = sch.get(0).start;
                    Interval newFreeInterval = new Interval(lastMeet.end, newFreeEnd);
                    sch.add(0, newFreeInterval);
                }
            }
        }
        return ans.subList(1, ans.size());
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> input) {
        List<Interval> schedules = new ArrayList<>(input.stream().flatMap(Collection::stream).toList());
        schedules.sort(Comparator.comparingInt(x -> x.start));

        List<Interval> result = new ArrayList<>();
        Interval prev = schedules.get(0), cur;
        for (int i = 1; i < schedules.size(); i++) {
            cur = schedules.get(i);
            if (cur.start > prev.end) {
                result.add(new Interval(prev.end, cur.start));
            }
            prev.end = Math.max(cur.end, prev.end);
        }
        return result;
    }

}

class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s]", start, end);
    }
}
