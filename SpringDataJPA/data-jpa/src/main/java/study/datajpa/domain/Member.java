package study.datajpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    protected Member() { // 기본 생성자를 protected로 해주는 것이 좋다.(public 보다는)
    }

    public Member(String username) {
        this.username = username;
    }
}
