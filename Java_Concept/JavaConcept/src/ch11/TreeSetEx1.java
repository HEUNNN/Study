package ch11;

import java.util.*;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet tSet = new TreeSet();

        String from = "b";
        String to = "d";

        tSet.add("abc"); tSet.add("alien"); tSet.add("bat");
        tSet.add("car"); tSet.add("Car"); tSet.add("disc");
        tSet.add("dance"); tSet.add("dZZZZ"); tSet.add("dzzzz");
        tSet.add("elepahant"); tSet.add("elevator"); tSet.add("fan");
        tSet.add("flower");

        System.out.println(tSet);
        System.out.println("range search: from" + from + " to" + to);
        System.out.println("result1: " + tSet.subSet(from, to));
        System.out.println("result2: " + tSet.subSet(from, to + "zzz"));
    }
}
