import kr.inflearn.MyClass;

public class TPC33 {
    public static void main(String[] args) {
        kr.inflearn.MyClass my = new kr.inflearn.MyClass(); // 보통은 kr.inflearn과 같이 풀네임으로 작성은 잘 안함
        // Package 경로를 import 했으면, kr.inflearn과 같이 풀네임 생략이 가능하다.
        int res = my.sum(10,100);
        System.out.println(res);
    }
}
