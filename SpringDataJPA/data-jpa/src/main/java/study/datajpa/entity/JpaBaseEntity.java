package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {
    // 순수 JPA 사용하여 Auditing
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist // persist 하기전에 event가 발생하는 것을 감지한다. 즉, 최초 등록된 데이터의 시간 기록
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now; // this 생략
        updatedDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
