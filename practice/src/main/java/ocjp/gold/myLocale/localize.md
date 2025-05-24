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
## 프로퍼티
### 프로퍼티 파일
##### 프로퍼티 파일에 적는 키와 값의 표기
```properties
# 방법1
key=value
# 방법2
key:value
```
##### getProperty : 프로퍼티 파일의 값 가져오기
```java
Properties prop = new Properties();
prop.load(new FileReader("sample.properties"));
String value = prop.getProperty("key");
```
##### 프로퍼티 파일을 읽고 쓰는 프로그램에서 디버그 차원에서 프로퍼티 파일의 키와 값을 일람표시 하기위한 방법
- Properties클래스의 list메소드에 PrintWriter형 오브젝트에 참조를 넘긴다.
##### 프로퍼티 파일을 Unicode표기로 변환하는 커맨드
```shell
$ native2ascii input.properties output.properties
```
### 프로퍼티 번들(Bundle)
##### 프로퍼티 파일을 읽어들여 ResourceBundle 오브젝트를 취득
```java
// sample.properties파일 읽기 (확장자나 로케일정보 불필요)
ResourceBundle resource = ResourceBundle.getBundle("sample");
```
- 위 소스에서 만약 디폴트 로케일이 `ja_JP`인 경우, `sample_ja_JP.properties`와 `sample.properties`파일이 둘 다 존재한다면 `sample_ja_JP.properties`를 우선적으로 읽는다.
- 로케일 정보에 대응하는 프로퍼티 파일이 없다면 `MissingResourceException`발생
- 디폴트 로케일이 아닌 다른 로케일 정보를 읽고 싶다면
```java
ResourceBundle resource = ResourceBundle.getBundle("sample", Locale.US);
```
## 포맷
### 날짜 포맷(DateTimeFormatter)
#### DateTimeFormatter 정수
- BASIC_ISO_DATE : 20111203
- ISO_LOCAL_DATE : 2011-12-03
- ISO_LOCAL_TIME : 10:15:30
- ISO_ORDINAL_DATE : 2012-337 (2012년의 337일째)
### NumberFormat 클래스
- 통화 포맷 : `NumberFormat.getCurrencyInstance(Locale.US);`
- 퍼센트 포맷 : `NumberFormat.getPercentInstance();`
