package ch11;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet();
        for (int i = 0; i < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(num);
        }
        System.out.println("set: " + set);
        // set 은 데이터의 모음 = collection
        List list = new LinkedList(set); // LinkedList(Collection c)
        Collections.sort(list); // Collections.sort(List list)로 sort() 메서드는 인자로 List 인터페이스 타입을 필요로 하기 때문에 LinkedList에 collection을 넣어 List 인스턴스를 생성하여 전달하였다.
        // Collection은 인터페이스이고, Collections는 클래스이다. -> sort()는 static method
        System.out.println("Sorted list: " + list);
    }
}
