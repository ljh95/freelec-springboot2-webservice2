package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
/*qhxhd ibatis등에서 Dao라고 불리는 DB Layer 접근자입니다. JPA에선 Repository라고 부르며 인터페이스로 생성합니다. 단순히 인터헤이스를 생성 후, JpaRepository<Entity 클래스, PK타입>
* 을 상속하면 기본적인 CRUD메소드가 자동으로 생성됩니다.
* @Repository를 추가할 필요도 없습니다. 여기서 주의할 점은 Entity클래스와 기본 Entity Repository는 함께 위치해야 하느나 점입니다. 둘은 아주
* 밀접한 관계이고, Entity클래스는 기본 Repository없이는 제대로 역할을 할 수가 없습니다.
* 나중에 프로젝트 규모가 커져 도메인별로 프로젝트를 부닐해야한다면 이때 Entity클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리합니다.
* */