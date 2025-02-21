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
        
    }
}
