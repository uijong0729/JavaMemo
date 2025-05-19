## 로컬라이즈
#### 디폴트 로케일 정보 취득
```java
Locale locale = Locale.getDefault();
```
#### 일본지역+일본어 로케일 정보 취득
```java
// 생성자를 이용
Locale locale = new Locale("ja", "JP");
// static정수에서 취득
Locale locale2 = Locale.JAPAN;
// 빌더를 이용
Locale locale3 = new Locale.Builder()
                    .setLanguage("ja")
                    .setRegion("JP")
                    .setScript("Japan")
                    .build();
```
#### 미국 로케일 정보 정수
```java
Locale locale = new Locale("en", "US");
Locale locale2 = Locale.US;
```
#### IETF language tag
- IETF BCP 47 언어 태그는 인터넷에서 인간 언어를 식별하는 데 사용되는 표준화된 코드입니다 
- IETF : 국제 인터넷 표준화 기구
- (Internet Engineering Task Force)
```java
// 미국
Locale locale = Locale.forLanguageTag("en-US-x-lvariant-POSIX");

// 일본
Locale locale = Locale.forLanguageTag("ja-JP-x-lvariant-JP")
```
## 프로퍼티 파일
##### 프로퍼티 파일에 적는 키와 값의 표기
```properties
# 방법1
key=value
# 방법2
key:value
```
##### 프로퍼티 파일을 읽고 쓰는 프로그램에서 디버그 차원에서 프로퍼티 파일의 키와 값을 일람표시 하기위한 방법
- Properties클래스의 list메소드에 PrintWriter형 오브젝트에 참조를 넘긴다.
