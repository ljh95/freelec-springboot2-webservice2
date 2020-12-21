package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
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
}

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