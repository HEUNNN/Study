public class TPC02 {
    public static void main(String[] args) {
        // 프로그래밍의 3대 요소: 변수, 자료형, 할당 연산자(=)
        // 1+1=2, 메모리(ram)에서 해당 계산이 이루어져야 한다. 1, +, 1 등을 저장할 기억 공간이 필요한데, 이 기억공간에 정해주는 이름을 변수라 한다.
        // 자료형: 기억공간의 크기와 어떤 종류의 데이터를 저장할 것인가를 결정하기 위해 '자료형'을 정의한다.
        // => 자료형을 정의해야 변수가 완성된다. (자료형: int, float, char, boolean 등..)
        // => 자료형과 변수 명을 결합하여 정의하는 것을 변수 선언이라고 하며, 변수를 선언이 되어야 기억 공간이 만들어진다.
        int a, b, c; // 변수 선언 -> 변수테이블이 생성(변수이름과 번지로 구성된 테이블)
        a=1; // 할당
        b=1;
        c=a+b;
        System.out.println(c);

        float floatnum = 34.5f;
        System.out.println(floatnum);

        char d; // char 은 알파벳 하나, apple 과 같은 것은 string 자료형이다.
        d='c';
        System.out.println(d);

        boolean g = true;
        System.out.println(g);
    }
}
