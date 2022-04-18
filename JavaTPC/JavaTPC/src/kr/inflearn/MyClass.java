package kr.inflearn;

public class MyClass {
    // Package에서 Public을 생략하면 default 의미를 갖는 접근제권한이 적용된다.
    // default는 단어가 아니라 의미만 생각한다. (default class MyClass로 작성하면 안됨)
    // default는 같은 패키지(kr.inflearn) 내부에 위치하는 class들 끼리는 사용이 가능하고,
    // 외부의 class에서는 접근을 못하게 한다.
    // 보통은 public 사용한다.
    public int sum(int a, int b) {
        int hap = 0;
        for (int i = 0; i <= b; i++) {
            hap += i;
        }
        return hap;
    }

}
