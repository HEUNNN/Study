package ch11;

import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};

        TreeMap map = new TreeMap();

        for (int i = 0; i < data.length; i++) {
            if(map.containsKey(data[i])) {
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], value.intValue() + 1); // 덮어쓰기
            } else {
                map.put(data[i], 1); // 지정된 key와 value를 TreeMap에 저장
            }
        }
        Iterator it = map.entrySet().iterator();
        System.out.println("= 기본 정렬 ="); // key의 알파벳 순서대로 정렬됨(오름차순)
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
        }
        System.out.println();

        // map을 ArrayList로 변환한 다음에 Collections.sort()로 정렬
        Set set = map.entrySet();
        List list = new ArrayList(set); // Set, List는 Colletion의 자손
        Collections.sort(list, new ValueComparator()); // value 값을 내림차순으로 정렬하는 ValueComparator()

        it = list.iterator();

        System.out.println("= 값(value)가 큰 순서로 정렬 =");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
        }

    }
    static class ValueComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                Map.Entry e1 = (Map.Entry)o1;
                Map.Entry e2 = (Map.Entry)o2;

                int v1 = ((Integer)e1.getValue()).intValue();
                int v2 = ((Integer)e2.getValue()).intValue();
                return v2 - v1;
            }
            return -1;
        }
    }

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];
        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
        return new String(bar);
    }
}
