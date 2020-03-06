# 스프링 공부하면서 만든 예제들
---

&nbsp;
&nbsp;
&nbsp;

## Spring AOP
---
  스프링 AOP 적용한 예제



&nbsp;
&nbsp;
&nbsp;

## Spring FileTransfer
---
  common 모듈을 이용해서 만든 예제
  - Ajax 이용한 업로드 구현 --> 업로드 할때 썸네일 보이도록 처리
  - 다운로드 구현 --> 다운로드할때 익스플로러, 엣지 예외처리 해줬음(크롬 같은 경우는 한글이 깨지지않도록 ISO 처리)



&nbsp;
&nbsp;
&nbsp;


## Spring Security
---
  스프링 시큐리티 의존성을 이용한 예제
  - 특이하게 spring-context.xml 파일을 따로 만들어 관리함
  - web에서 선언해주는 컨텍스트 파일이며 필터를 이용함
  - 스프링 컨텍스트에서 인터셉트 이용해서 로그인처리
  - 스프링 시큐리티 패스워드 인코더 설정 :  <https://mkyong.com/spring-security/spring-security-password-hashing-example/>
  - CSRF 설정완료


## SpringJPA-SecurityAuth
---
  예제에 나와있는 JDBC를 이용하는 것과 달리 JPA를 이용해서 여러 테스트를 만들어 보는 예제
  - JPA를 이용하려면 persistence.xml을 만들고 그걸 src/main/resource/META-INF에 넣어주는데 JPA가 그걸 자동으로 인식함
  - 하이버네이트는 써도되고 안써도 되지만 보통 묶어서 사용함
  - 엔티티클래스 만들때 직렬화 인터페이스를 구현해주는 이유 : <https://stackoverflow.com/questions/2020904/when-and-why-jpa-entities-should-implement-serializable-interface> --> 결론부터 말하자면 세션에 기록하거나 다른 인터페이스로 넘기지 않으면 굳이 구현할필요는 없지만 일단 구현해서 나쁠건 없다고 생각한다.
  - JPA, 하이버네이트 그리고 엔티티와 리포지터리에 대한 작성은 했지만 빈즈 config에서 오류가 발생함
  - 에러 해결 --> pom.xml 에서 하이버네이트 버전 수정 및 authoritiesEntity @Id 새로 설정