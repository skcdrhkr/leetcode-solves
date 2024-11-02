package topo;

import java.util.*;
import java.util.stream.Stream;

public class AlienDictionary {

    public static void main(String[] args) {
        // Case 1
        List<String> case1 = Stream.of("xro", "xma", "per", "prt", "oxh", "olv").toList();
        System.out.println(AlienDictionary.alienOrder(case1));

        // Case 2
        List<String> case2 = Stream.of("o", "l", "m", "s").toList();
        System.out.println(AlienDictionary.alienOrder(case2));

        // Case 3
        List<String> case3 = Stream.of("mdxok", "mrolw", "mroqs", "kptz", "klr", "klon", "zvef", "zrsu", "zzs", "orm", "oqt").toList();
        System.out.println(AlienDictionary.alienOrder(case3));
    }

    public static String alienOrder(List<String> words) {
        int len = words.size();
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String pre = words.get(i);
                String post = words.get(j);
                int index = 0;
                while (index < pre.length() && index < post.length() && pre.charAt(index) == post.charAt(index))
                    index++;
                if (index < pre.length() && index < post.length()) {
                    char earlier = pre.charAt(index);
                    char later = post.charAt(index);
                    graph.computeIfAbsent(earlier, z -> new HashSet<>()); //.add(post.charAt(index));
                    if (!graph.get(earlier).contains(later)) {
                        graph.get(earlier).add(later);
                        indegree.put(later, indegree.getOrDefault(later, 0) + 1);
                    }
                    indegree.putIfAbsent(earlier, 0);
                }
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        for (Character cur : indegree.keySet()) {
            if (indegree.get(cur) == 0) queue.add(cur);
        }
        while (!queue.isEmpty()) {
            Character front = queue.poll();
            result.append(front);
            HashSet<Character> neighbours = graph.getOrDefault(front, new HashSet<>());
            for (Character neigh : neighbours) {
                indegree.put(neigh, indegree.get(neigh) - 1);
                if (indegree.get(neigh) == 0) queue.add(neigh);
            }
        }
        if (result.length() != indegree.size()) return "";
        return result.toString();
    }
}
