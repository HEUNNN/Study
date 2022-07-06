package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(unique = true, length = 10)
    private String name;
    private int age;

    public Member() {}

    public Member(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
