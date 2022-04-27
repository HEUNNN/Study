package ch11;

import java.util.*;

public class MyStack extends Vector {
    // Stack 직접 구현하기
    public Object push(Object item) {
        addElement(item);
        return item;
    }
    // pop(), peek()이 반환하는 값을 확인하기
    public Object pop() { // stack의 맨 위에 저장된 객체를 꺼낸다.
        Object obj = peek(); // stack에 저장된 마지막 요소를 읽어온다.
        // stack이 비어있으면 peek() 메서드가 EmptyStackException을 발생시킨다.
        // 마지막 요소를 삭제한다. 배열의 index가 0부터 시작하므로 1을 빼준다.
        removeElementAt(size() - 1); // 지정된 index의 요소를 제거해주는 메서드
        return obj;
    }
    public Object peek() {
        int len = size(); // Stack instance = si , si.peek() 하면 si.size()를 구하여 len 변수에 넣어준다.
        if(len  == 0) {
            throw new EmptyStackException();
        }else {
            return elementAt(size() - 1); // 배열의 마지막 요소를 반환한다.
        }
    }
    public boolean empty() { // Stack instance = si , si.empty() 하면 si.size() == 0 인지에 대해 true or false 반환
        return size() == 0;
    }
    public int search(Object o) {
        int i = lastIndexOf(o); // Stack instance = si , si.search(Object o) -> int i = si.lastIndexOf(o)를 한다.
        if(i < 0) {
            return -1;
        } else {
            return size() - i; // Stack은 맨 위에 저장된 객체의 index를 1로 정의
        }
    }
}
class MyStackTest {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.addElement("apple");
        System.out.println(ms.peek()); // apple
    }
}