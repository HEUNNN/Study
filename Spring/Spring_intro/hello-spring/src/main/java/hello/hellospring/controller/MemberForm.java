package hello.hellospring.controller;

public class MemberForm {
    private String name; // createMemberForm의 input 태그의 name="name"을 보고 Spring이 MemberForm class의 setName을 통해 name을 넣어준다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
