package ch11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김자바", 100);
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        // map의 값(value)를 출력하려면 key 값으로 일일히 찾아줘야 하기 때문에 entrySet()을 사용하여 Set으로 바꾸어준다.
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next(); // set 요소의 데이터를 Map.Entry type으로 변환 -> Entry는 Map의 내부 클래스
            System.out.println("이름: " + e.getKey() + ", 점수: " + e.getValue());
        }

        Set member = map.keySet();
        System.out.println("참가자 명단: " + member);

        Collection values = map.values();
        // System.out.println(values); // [90, 100, 80, 100]
        it = values.iterator();
        int sum = 0;
        while (it.hasNext()) {
            sum += (int)it.next();
        }
        System.out.println("총점: " + sum);
        System.out.println("평균: " + (float)sum/set.size());
        System.out.println("최고점수: " + Collections.max(values));
        System.out.println("최저점수: " + Collections.min(values));
    }
}
