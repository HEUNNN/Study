package hellojpa;

import javax.persistence.*;


@Entity
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
@TableGenerator(name = "MEMBER_SEQ_GENERATOR", table = "MY_SEQUENCES", pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

/*  // 객체를 테이블에 맞추어 모델링 → 객체 지향적인 방법은 아니다.
    @Column(name = "TEAM_ID")
    private Long teamId;*/

    // 객체 지향 모델링
    // JPA에게 관계에 대해서 알려줘야 한다.
    // Member : Team = N : 1 이기 때문에 Member 입장에서는 ManyToOne으로 해야한다.
    @ManyToOne
    @JoinColumn(name = "TEAM_ID") // TEAM_ID(FK)과 Team 레퍼런스를 매핑해야한다.
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
