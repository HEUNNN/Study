package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    // Member : Team = N : 1, Team 입장에서는 @OneToMany
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

}
