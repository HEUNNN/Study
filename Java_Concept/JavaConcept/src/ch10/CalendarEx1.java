package ch10;

import java.util.Calendar;

public class CalendarEx1 {
    public static void main(String[] args) {
        // Calendar class는 추상 클래스이므로 인스턴스를 생성할 수 없다.
        // Calendar class의 static getInstance() 메서드를 사용하여 Calendar 추상 클래스를 상속받아 완전히 구현한 클래스 GregorianCalendar 인스턴스 등을 반환 받는다.
        Calendar today = Calendar.getInstance();
        System.out.println("이 해의 년도: " + today.get(Calendar.YEAR));
        System.out.println("월(0~11, 0:1월): " + today.get(Calendar.MONTH));
        System.out.println("이 해의 몇 째 주: " + today.get(Calendar.WEEK_OF_YEAR));

        // DATE와 DAY_OF_MONTH는 같다.
        System.out.println("이 달의 몇 일: " + today.get(Calendar.DATE));
        System.out.println("이 달의 몇 일: " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 해의 몇 일: " + today.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일(1~7, 1:일요일): " + today.get(Calendar.DAY_OF_WEEK));
    }
}
