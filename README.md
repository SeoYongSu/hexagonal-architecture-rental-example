# 육각형(핵사고널) 아키텍처를 적용한 간단한 대여 서비스 예제



### 서비스 설명 : 단순하게 대여 정보만 처리하는 서비스
  - 해당 서비스는 대여, 반납만 처리하는 서비스
  - Customer, Product는 타 서비스라고 가정함
  - 해당 서비스의 핵심 Domain은 Rent(대여)

### 비고 : 상세 구현은 skip


## 패키지 구조 및 설명
- 핵사고널 아키텍처 Doamin 영역

| 구분      | 패키지  명      | 유형        | 명명 규칙 | 비고                                                              |
|---------|-------------|-----------|-------|-----------------------------------------------------------------|
| Domain  | Domain name | Class     | 명사형   | 도메인 모델 비지니스 개념 및 로직 표현 & 애매한부분은 interface로 정의 |
| UseCase | UseCase     | InterFace | 공통    | 제너릭 Type의 interface를 통해 개발규칙 정의                                 |

- 핵사고널 아키텍처 내부 영역

| 구분          | 패키지  명     | 유형        | 명명 규칙                 | 비고                                                                                        |
|-------------|------------|-----------|-----------------------|-------------------------------------------------------------------------------------------|
| Application | Port - In  | InterFace | ~UseCase              | 인바운트 포트 인터페이스<br/>UseCase 인터페이스를 상속받아 Input과 Out 설정<br/>ex) InputDto, OutputDto 설정한다고 보면됨 |
|             | port - out | InterFace | ~Port<br/>~Repository | 아웃바운드 포트 인터페이스 <br/>~Port : 외부 또는 타서비스에 연동 <br> ~Repository : DB관련 아웃바운드포트                |
|             | Service    | Class     | ~Service              | ~UseCase의 구현체<br> 비지니스 로직 구현 및 Domain 모델에 접근                                              |

- 핵사고널 아키텍처 외부(Infra) 영역 
- Application에 InboundAdapter과 OutboundAdapter, 기타 외부의존성을 구현해주세요~
- 
| 패키지  명  | 비고                      |
|---------|-------------------------|
| Adapter | 핵사고널 아키텍처의 Infra 영역     |
| Config  | Application Config 설정영역 |

