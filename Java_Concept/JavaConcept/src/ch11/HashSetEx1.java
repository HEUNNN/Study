package ch11;

import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objArr = {"1", 1, "2", "2", "3", "3", "4", "4", "4"}; // "1" != 1
        Set set = new HashSet(); // HashSet은 Set 인터페이스를 implement한 클래스

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }
        System.out.println(set);
    }
}
