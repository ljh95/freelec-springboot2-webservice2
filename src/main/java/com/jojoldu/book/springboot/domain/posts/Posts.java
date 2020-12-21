package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
/*
* @Entity는 JAP의 어노테이셔ㄴ이며,
* 여기서 Posts클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통Entity클래스라고도 합니다.
* ,JPA를 사요하시면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity클래스의 수정을 통해 작업합니다.
* Posts클래스에는 JPA에서 제공하는 어노테이션들이 몇 개 있습니다.
*
* @GeneratedValue =
* PK의 생성 규칙으 ㄹ나타냅니다.
* 스프린 부트 2.0에서는 HenerationType/IDNEYTY옵션을 추가해야만 auto.increment가 됩니다.
* 스프링 부트 2.0과 1.5버전의 차이는 에 정리했습니다.
*
* @Column
* 테이블의 칼럼을 나타내며 굳이 선언하지 않더라고 해당 클래스의 필드는 모두 컬럼이 됩니다.'
* 사용한ㄴ 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
* 문자열의 경우 VARCHAR(255)가 기본값인데 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶거나 등의 경우 사용됩니다.
*
*
* @Builder
* 해당 클래스의 빌더 패턴 클래스를 생성
* 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
*
* Setter메소드 대신 새당 필드의 값 벼ㄴ경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 합니다.
*
* 기본적인 DB삽입은 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것 이며, 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 합니다.
* 이 책에서는 생성자 대신에 @Builder를 통해 제공되는 빌더 클래스를 사용합니다. 생성자나 빌더나 생성 시점에 값을 채워주는 역할을 똑같습니다.
* 다만 생성자의 경우 지금 채워야할 필등가 무엇인지 명확히 지정할 수 가 없습니다.
* */