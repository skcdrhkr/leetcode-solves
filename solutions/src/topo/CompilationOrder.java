package topo;

import java.util.*;

class CompilationOrder {

    public static void main(String[] args) {
        // Case 1
        ArrayList<ArrayList<Character>> case1 = new ArrayList<>();
        case1.add(new ArrayList<>(List.of('B', 'A')));
        case1.add(new ArrayList<>(List.of('C', 'A')));
        case1.add(new ArrayList<>(List.of('D', 'C')));
        case1.add(new ArrayList<>(List.of('E', 'D')));
        case1.add(new ArrayList<>(List.of('E', 'B')));
        System.out.println(CompilationOrder.findCompilationOrder(case1));

        ArrayList<ArrayList<Character>> case2 = new ArrayList<>();
        case2.add(new ArrayList<>(List.of('B', 'A')));
        case2.add(new ArrayList<>(List.of('C', 'A')));
        case2.add(new ArrayList<>(List.of('D', 'B')));
        case2.add(new ArrayList<>(List.of('E', 'B')));
        case2.add(new ArrayList<>(List.of('E', 'D')));
        case2.add(new ArrayList<>(List.of('E', 'C')));
        case2.add(new ArrayList<>(List.of('F', 'D')));
        case2.add(new ArrayList<>(List.of('F', 'E')));
        case2.add(new ArrayList<>(List.of('F', 'C')));
        System.out.println(CompilationOrder.findCompilationOrder(case2));
    }

    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> result = new ArrayList<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (ArrayList<Character> cur : dependencies) {
            Character dependent = cur.get(0);
            Character dependency = cur.get(1);
            indegree.put(dependency, 0);
            indegree.put(dependent, 0);
            graph.put(dependency, new ArrayList<>());
            graph.put(dependent, new ArrayList<>());
        }
        for (ArrayList<Character> cur : dependencies) {
            Character dependent = cur.get(0);
            Character dependency = cur.get(1);
            graph.get(dependency).add(dependent);
            indegree.put(dependent, indegree.get(dependent) + 1);
        }
        LinkedList<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            Character top = queue.poll();
            result.add(top);
            List<Character> neighbors = graph.get(top);
            for (Character neigh : neighbors) {
                indegree.put(neigh, indegree.get(neigh) - 1);
                if (indegree.get(neigh) == 0) {
                    queue.add(neigh);
                }
            }
        }
        if (result.size() != graph.size()) return new ArrayList<>();
        return result;
    }
}