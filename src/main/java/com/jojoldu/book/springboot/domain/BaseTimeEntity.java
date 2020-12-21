package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

/*
* 1. MappedSuperClass
* Jap Entity클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록 합니다.
*
* 2. @EntityListeners(AuditingEnctityListener.class)
* BaseTimeEntity클래스에 Auditin 기능을 포함시킵니다.
*
* 3. CreateDate
* Entity가 생성되어 저장될 떄 시간이 자동 저장됩니다.
*
* 4. LastModifiedDate
* 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다.
*
* */