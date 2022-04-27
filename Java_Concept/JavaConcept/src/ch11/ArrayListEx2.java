package ch11;

import java.util.*;

public class ArrayListEx2 {
    // 긴 문자열 데이터를 원하는 길이로 잘라서 ArrayList에 담은 후 출력
    public static void main(String[] args) {
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ"; // length -> 43
        int length = source.length();

        List list = new ArrayList(length/LIMIT + 10); // length/LIMIT을 더하여 크기를 약간 여유있게 잡는다.
        // System.out.println(length/LIMIT); // 4

        for (int i = 0; i < length; i += LIMIT) {
            if(i + LIMIT < length) {
                list.add(source.substring(i, i + LIMIT));
            } else {
                list.add(source.substring(i));
                // System.out.println(source.substring(i)); // i부터 끝까지 substring
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
