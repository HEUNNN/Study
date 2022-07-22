package study.datajpa.dto;

import lombok.Data;
import study.datajpa.domain.Member;

@Data
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    // 엔티티인 Member는 MemberDto를 알면 안되지만, MemberDto는 Member 엔티티를 알아도 된다.
    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        if (member.getTeam() != null) {
            this.teamName = member.getTeam().getName();
        }

    }
}
