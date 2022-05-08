package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// JPA를 사용하려면 Entity 매핑이 필요하다.
@Entity
public class Member {
    // PK mapping을 해주어야 한다. 지금 사용하는 Primary-Key(PK)는 DB table에 insert시 DB에서 자동으로 생성해준다. 그 기능을 Indetity라고 한다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    // 만약 DB table의 Column 명이 username이라면 @Column(name = "username")을 붙여주면 mapping 된다.
   private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
