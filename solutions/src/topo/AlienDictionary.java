package topo;

import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionary {

    public static void main(String[] args) {
        // Case 1
        List<String> case1 = List.of("xro", "xma", "per", "prt", "oxh", "olv");
        System.out.println(AlienDictionary.alienOrder(case1));

        // Case 2
        List<String> case2 = List.of("o", "l", "m", "s");
        System.out.println(AlienDictionary.alienOrder(case2));

        // Case 3
        List<String> case3 = List.of("mdxok", "mrolw", "mroqs", "kptz", "klr", "klon", "zvef", "zrsu", "zzs", "orm", "oqt");
        System.out.println(AlienDictionary.alienOrder(case3));

        // Case 4
        List<String> case4 = List.of("mtaky", "mtakyxy", "mtakyxyrr", "mtakyxyrrvc", "mtakyxyrrvcuq", "mtakyxyrrvcuqnu", "mtakyxyrrvcuqnufn", "mtakyxyrrvcuqnufnam");
        System.out.println(AlienDictionary.alienOrder(case4));
    }

    public static String alienOrder(List<String> words) {
        int len = words.size();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indgree = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        for (int i = 1; i < len; i++) {
            String prev = words.get(i - 1);
            String cur = words.get(i);
            boolean valid = updateGraph(prev, cur, graph, indgree, allChars);
            if (!valid) return "";
        }
        if(graph.isEmpty()) {
            return String.join("", words.stream().flatMap(str -> str.chars().mapToObj(Character::toString)).collect(Collectors.toSet()));
        }
        StringBuilder result = performTopologicalSort(graph, indgree);
        if (result.isEmpty()) return "";
        for (char c : result.toString().toCharArray()) {
            allChars.remove(c);
        }
        for (char c : allChars) {
            result.append(c);
        }
        return result.toString();
    }

    private static StringBuilder performTopologicalSort(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> indgree) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        for (Integer key : indgree.keySet()) {
            if (indgree.get(key) == 0) queue.add(key);
        }
        if (queue.isEmpty()) return new StringBuilder();
        while (!queue.isEmpty()) {
            Integer front = queue.pollFirst();
            result.append((char) (front + 'a'));
            Set<Integer> neighbors = graph.get(front);
            if (neighbors != null) {
                for (Integer cur : neighbors) {
                    indgree.put(cur, indgree.get(cur) - 1);
                    if (indgree.get(cur) == 0) queue.add(cur);
                }
            }
        }
        if (result.length() != indgree.keySet().size()) {
            return new StringBuilder();
        }
        return result;
    }

    private static boolean updateGraph(String prev, String cur, Map<Integer, Set<Integer>> graph, Map<Integer, Integer> indegree, Set<Character> allChars) {
        int prevLen = prev.length();
        int curLen = cur.length();
        int pInd = 0, curInd = 0;
        while (pInd < prevLen && curInd < curLen) {
            char prevChar = prev.charAt(pInd);
            char curChar = cur.charAt(curInd);
            allChars.add(prevChar);
            allChars.add(curChar);
            if (prevChar != curChar) {
                if (graph.get(prevChar - 'a') == null) {
                    graph.put(prevChar - 'a', new HashSet<>());
                    graph.get(prevChar - 'a').add(curChar - 'a');
                    indegree.put(curChar - 'a', indegree.getOrDefault(curChar - 'a', 0) + 1);
                } else if (!graph.get(prevChar - 'a').contains(curChar - 'a')) {
                    graph.get(prevChar - 'a').add(curChar - 'a');
                    indegree.put(curChar - 'a', indegree.getOrDefault(curChar - 'a', 0) + 1);
                }
                if (!indegree.containsKey(prevChar - 'a')) {
                    indegree.put(prevChar - 'a', 0);
                }
                break;
            } else {
                pInd++;
                curInd++;
                if (curInd == curLen && pInd < prevLen) return false;
                if (pInd == prevLen) break;
            }
        }
        while (pInd < prevLen || curInd < curLen) {
            if (pInd < prevLen) {
                allChars.add(prev.charAt(pInd));
                pInd++;
            }
            if (curInd < curLen) {
                allChars.add(cur.charAt(curInd));
                curInd++;
            }
        }
        return true;
    }
}
