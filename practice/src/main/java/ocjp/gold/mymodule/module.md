# 모듈
## 모듈 개요
- 모듈을 패키지를 분리하는 구조
- 복수의 패키지를 합친 것이 모듈
- 공개설정하지 않은 패키지는 자동적으로 비공개 패키지 취급
- 모듈 시스템이 강화하는 것은 어플리케이션이 어떠한 패키지나 클래스에 성립되어 있는가를 은닉하는 **정보 은닉**이며, 클래스나 필드를 은닉하는 것은 캡슐화를 유지하는 **데이터 은닉**과 관계없다.
- 그 외 장점
    - 플랫폼 간 정합성을 향상
    - 유연한 실행환경을 실현
## 모듈 정의 파일
- module-info.java
```java
module com.sample.Test {
    // 내 쪽에서 공개하고싶은 패키지
    exports com.sample.service;
    // 이용하고 싶은 다른 패키지
    requires com.sample.Util;
    // 공개하진 않지만 리플렉션으로 접근할 수 있게 함
    opens com.sample.value.core;
    // com.sample.Test에만 리플렉션 접근을 허용
    opens com.sample.value.core to com.sample.Test;
}
```
- java.base모듈은 자동적으로 requires되기 때문에 생략가능 
## 모듈 경로(module path)
- 임의의 장소를 모듈 경로에 추가하고 싶은 경우 java또는 javac커맨드에 `--module-path`옵션을 지정
## 모듈 3종류
- **名前付きモジュール**
    - 모듈 정의 파일 module-info.java에 모듈명이 정의된 모듈
- **自動モジュール**
    - 모듈 정의 파일을 갖지않고 모든 패키지가 공개된 것으로 간주되는 모듈
    - 自動モジュール의 모듈명은 `META_INF/MANIFEST.MF`에 `Automatic-Module-Name`속성에서 지정가능
- **無名モジュール**
    - 自動モジュール로부터 참조할수 있지만 名前付きモジュール로부터는 참조할수 없는 모듈. 모듈명이 없기 때문에 module-info.java에 requires 할 수 없기 때문
## 모듈 이행
#### 바텀-업 이행
- 가장 이용되는(의존되는) 무명모듈부터 기명모듈로 순서대로 변환해가는 방법
#### 탑-다운 이행
- 이용되는(의존되는) 무명모듈부터 자동모듈로 변환해가는 것
- 이용되는(의존되는) 모듈은 일단 자동모듈로 변환해가는 것
## DIP(Dependency Inversion Principle, 의존 역전 원칙)
- 객체에서 어떤 Class를 참조해서 사용해야하는 상황이 생긴다면, 그 Class를 직접 참조하는 것이 아니라 그 대상의 상위 요소(추상 클래스 or 인터페이스)로 참조하라는 원칙
## SPI (Service Provider Interface)
- 서비스 공급자 인터페이스
- Java SPI는 **java.util.ServiceLoader** 클래스에 있습니다. ServiceLoader 클래스는 서비스 인터페이스를 사용하고 서비스 구현의 Iterable을 반환하는 정적 메서드 **load**를 제공합니다.
```java
// load메소드는 class리터럴을 인수로 받는다
Iterator<Hello> hellos = ServiceLoader.load(Hello.class).iterator();
```
- META-INF/services 안의 파일을 검색한다
- ClassLoader와 헷갈림 주의 : ClassLoader는 클래스 파일을 로드하기위한 클래스이며, ServiceLoader는 클래스 파일을 로드하기위한 클래스가 아니다
- **uses** : SPI모듈을 실현하기위해 공개하는 인터페이스를 모듈 정의 파일(module-info.java)에 선언할 때 사용하는 디렉티브
- SPI이용측
```java
module app {
    exports app;
    // app.Hello 인터페이스를 SPI로써 사용
    uses app.Hello;
}
```
- SPI구현측
```java
module lib {
    exports lib;
    // uses가 있는 모듊명을 requires로 포함시켜야 한다
    requires app;
    // app.Hello의 구현체는 lib모듈의 HelloImpl클래스입니다.
    provides app.Hello with lib.HelloImpl;
}
```
## jdeps
- jdeps는 JDK에 포함된 툴로, 클래스나 모듈의 의존관계를 조사하기위한 커맨드
```shell
$ jdeps app/app.jar
```
- 클래스 수준준의 의존관계 검색
```shell
$ jdeps -verbose:class -cp lib/tools.jar com.sun.tools.jdeps.Main
```
- JDK내부(jdk internal) API에서 클래스 수준준의 의존관계를 검색
```shell
$ jdeps -jdkinternals myapplication.jar
```