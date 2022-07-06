package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id // PK 매핑
    private Long id;

    @Column(name = "name", nullable = false)
    private String username; // 객체에서는 username으로 쓰고, DB에서는 column 명을 name으로 한다.

    private Integer age; // DB에서 Integer와 가장 유사한 것으로 선택된다.

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {
    }
}
