package kr.inflearn;

public class IntArray { // 배열처럼 동작하는 IntArray class(API) 설계
    private int count;
    private int[] intArr;

    // 배열 생성 기능 구현
    public IntArray() {
        this(10); // IntArray 객체 생성시 parameter로 int를 넘겨주지 않으면 배열의 크기는 10으로 설정한다는 뜻이다.
    }
    public IntArray(int init) {
        intArr = new int[init];
    }

    // 배열 원소 삽입 기능 구현
    public void add(int data) {
        intArr[count++] = data;
    }

    // 배열의 원소 값을 반환하는 기능 구현
    public int get(int idx) {
        return intArr[idx];
    }

    // 배열의 크기를 반환하는 기능 구현
    public int size() {
        return count;
    }
}
