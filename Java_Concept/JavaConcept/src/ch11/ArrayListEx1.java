package ch11;
import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;


public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
        int[] intArr = {5, 4, 2, 0, 1, 3};
        for (int i = 0; i < intArr.length; i++) {
            list1.add(intArr[i]);
        }
        ArrayList list2 = new ArrayList(list1.subList(1,4)); // fromIdx 부터 toIdx 사이에 저장된 객체를 반환한다.
        print(list1, list2);

        //Java에서 정렬은 Collections.sort() 사용
        Collections.sort(list1); // list1을 숫자 순서대로 정렬 -> list1 원본이 변경 됨
        Collections.sort(list2);
        System.out.print("Sroted List ->  ");
        print(list1, list2);

        System.out.println("list1.containsAll(list2): " + list1.containsAll(list2)); // true
        System.out.println("list2.containsAll(list1): " + list2.containsAll(list1)); // false
        System.out.println("list2.contains(list1): " + list2.contains(list1)); // false

        list2.add("b");
        list2.add("c");
        list2.add(3, "a");
        System.out.print("add the char to list2 ->  ");
        print(list1, list2);

        list2.set(3, "AA");
        System.out.print("set the string 'AA' to list2 ->  "); // 덮어 씌움
        print(list1, list2);

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
        list1.retainAll(list2);
        System.out.print("list1.retainAll(list2) ->  ");
        print(list1, list2);

        // list2 에서 list1에 포함된 객체들을 삭제
        for (int i = list2.size() - 1; i >= 0; i--) { // 삭제는 뒤에서부터 탐색하는것이 좋음
            if(list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        System.out.print("list2 에서 list1에 포함된 객체들을 삭제 ->  ");
        print(list1, list2);
    }
   static void print(ArrayList list1, ArrayList list2) {
        System.out.print("list1: " + list1 + "  ");
        System.out.println("list2: " + list2);
        System.out.println();
    }
}
