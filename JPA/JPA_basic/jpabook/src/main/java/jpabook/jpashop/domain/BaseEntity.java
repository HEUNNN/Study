package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    private String createBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
