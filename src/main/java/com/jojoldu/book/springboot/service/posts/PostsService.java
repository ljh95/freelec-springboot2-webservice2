package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        return new PostsResponseDto(entity);
    }
}

/*
* 여기서 신기한 것이 있습니다. update기능에서 데이터베이스에 쿼리를 날리는 부분이 없습니다. 이게 가능한 이유는 JPA의 영속성 컨텍스트 때문입니다.
* 영속성 컨텍스트란, 엔티티를 영구 저장하는 환경입니다. 일종의 논리적 개념이라고 보시면 되며, JPA의 핵심 내용은 엔티티가 연속성 컨텍스트레 포함되어 이쌰 아니냐라로 갈립니다.
*
* JPA의 엔티티 매니저가 활성화된 상태로(Spring Data Jpa를 쓴다면 기본 옵션) 트랜잭션안에서 데이터베이스에서 데이터를 가져오면
* 이데이터는 영속성 컨텍스트가 유지된 상태입니다.
* 이 상태에서 해당데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테아불애 ㄱ=뵨굥뷴울 반영합니다. 즉, Entity객체의 값만 변경하면 별도의 Update쿼리를 날릴 필요가 없다는 것이죠
* 이 개념을 더티 체킹이라고 합니다.
*
* */

/*
* 스프링을 어느 정도 써보셨던 분들이라면 Controller와 Service에서 Autowired가 없는 것이 어색하게 느껴집니다. 스프링에선 Bean을 주입받는 방식들이 다음과 같습니다.
* 1, @Autowired,
* 2. setter,
* 3. 생성자
*
* 이 중 가장 권장하는 방식이 생성자로 주입하는 방식입니다.
* 즉 생성자로 Bean객체를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있다는 것입니다. 그러면 앞으로 생성자는 어디있을까요?
* 바로 @RequiredArgsConstructor에서 해결해 줍니다. final이 선언된 필드를 인자값으로 하는 생성자를 롬복의 @requiredArgsContructor가 대신 생성해준 것 입니다.
* 생성자를 직업 안 쓰고 롬복 어노테이션을 사용한 이유는 간잔합니다. 해당 클랫의 의존성 과계가 변경될 떄마다 생성자 코드를 계속해서 숮어하는 번저로움을 새결하기 위함입니다.
*
*
* */