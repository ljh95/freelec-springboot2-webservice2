package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
* 앞으로 만들 프로젝트의 메인 클래스가 됩니다.
* @SpringBootApplication으로 인해 스프링 부트의 자동 설정, ㅍ스프링 Bean읽기와 생성을 모두 자동으로 설정됩니다.
* 튻히나 @SpringBootApplication이 있는 위치부처 설정을 읽어가기때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 합니다.
* main 메소드에서 실행하는 SpringApplication.run으로 인해 내장 WAS를 실행합니다. 내장 WAS란 별도로 외부에 WAS를 두지 않고
* 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 이야기 합니다.
* 이렇게 되면 항상 서버에 토샛을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar파일로 실행하면 됩니다.
* 꼭 스프링 부트에서만 내장 WAS를 사용할 수 있는 것은 아니지만, 스프링 부트에서는 내장 WAS를 사용하는 것을 권장하고 있습니다. 이유는 정말 간단합니다.
* '언제 어디서나 같은환경에서 스프링 부트를 배포'할 수 있기 떄문입니다.
* 외장  WAS를 쓴다고 하면 몯느 서버 WAS의종류와 버전, 설정을 일치시켜야만 하빈다. 새로운 서버가 추가되면 모든 서버가 같은 WAS의 버전을 올린다고 하면 어떻게됭까요?
* 실수할 여지도 많고 시간도 많이 필요한 큰 작업이 될 수도 있습니다. 하지만 이ㅓㅀ게 내장 WSA를 사용할 경우 이 문ㅈ[를 모두 해결할 수 있습니다.
*
* */