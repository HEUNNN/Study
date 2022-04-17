import kr.TPC.MemberVO;

public class TPC15 {
    public static void main(String[] args) {
        MemberVO member1 = new MemberVO("hyeeun", 15, "010-1234-5678", "Korea Busan"); // 인스턴스 생성 & 초기화
        System.out.println(member1.toString());

        MemberVO member2 = new MemberVO();
        member2.setter("Lee", 25, "010-1234-1234", "Korea Seoul");
        System.out.println(member2); // System.out.println(member2.toString()); toString() 생략할 수 있다.


    }
}
