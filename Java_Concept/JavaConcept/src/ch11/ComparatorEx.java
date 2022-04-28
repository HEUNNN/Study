package ch11;

import java.util.*;

public class ComparatorEx {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr); // String의 Comparable implement에 의한 오름차순(기본 정렬기준) 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안함
        System.out.println("strArr = " + Arrays.toString(strArr));

        System.out.println("= 내림차순 정렬 =");
        Arrays.sort(strArr,new Descending()); // 내림차순 정렬, 지정한 comparator 인 Descending에 의한 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

    }
}
class Descending implements Comparator { // 내림차순 정렬 -> 기본 정렬기준(오름차순) 외에 다른 기준으로 정렬하고자 할 때 사용
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1; // -1을 곱해서 정렬방식의 역으로 변환한다.
        }
        return -1;
    }
}