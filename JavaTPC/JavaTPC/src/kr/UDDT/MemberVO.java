package kr.UDDT;
// 잘 설계한 class
public class MemberVO {
    private String name; // 정보은닉 -> Private
    private int age;
    private String tel;
    private String addr;
    // overloading
    public MemberVO() { }; // default 생성자 함수
    public MemberVO(String name, int age, String tel, String addr){
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.addr = addr;
    }

    // private 멤버 변수에 접근할 때는 setter, getter method를 활용한다.
    // setter method
    public void setter(String name, int age, String tel, String addr){
        // if 문 등을 사용하여 setter 에 입력되는 파라미터를 검사할 수 있다.
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.addr = addr;
    }
    // 기존에 정의되어 있는 toString()를 재정의 한 사실을 표기하기 위해 @Override 사용
    @Override
    public String toString(){
        return "MemberVO [name=" + name + ", age=" + age + ", tel=" + tel + ", addr=" + addr +"]";
    }

}
