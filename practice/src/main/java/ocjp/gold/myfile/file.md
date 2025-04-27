## java.io.File 클래스
- File클래스는 경로(Path)를 취급할 뿐이며 실제 파일이나 디렉토리(폴더) 그 자체를 나타내는 것은 아니다.
- listFiles : 디렉토리 내 일람을 File로서 가져오는 메소드
```java
File dir = new File(".");
File[] files = dir.listFiles();
for (File file : files) {
    System.out.println(file.getName());
}
```

## IO패키지
- 문자 스트림
    - 입력 : java.io.Reader
    - 출력 : java.io.Writer
- 장문의 문자스트림
    - 입력 : java.io.BufferedReader
    - 출력 : java.io.BufferedWriter
- 바이트 스트림
    - 입력 : java.io.InputStream
    - 출력 : java.io.OutputStream
- 사진 등의 고용량 바이트 스트림
    - 입력 : java.io.BufferedInputStream
    - 출력 : java.io.BufferedOutputStream

## 자바에서 newLine 메소드는 자동판별된다
- 캐리지 리턴(CR) : 윈도우기반 CRLF
- 라인 피드(LF) : Unix관련 OS들

## flush
- flush메소드는 버퍼와 파일을 강제로 동기화 시킨다

## java.io.Console
- 콘솔기반 프로그램 작성시 유용
- readPassword : 일반적인 콘솔 입력은 입력한대로 콘솔에 출력되지만, readPassword를 이용하면 사용자의 입력을 콘솔에 출력하지않고 입력으로 받을 수 있다
```java
Console console = System.console();
// readPassword의 반환형은 char[]임에 주의
char[] password = console.readPassword();
```

## java NIO
- NIO.2 : JSR 203 More New I/O APIs for the Java Platform
#### 경로정보와 파일조작 패키지의 분리
- java.nio.file.Path : 파일이나 디렉토리(폴더)의 경로를 나타냄
    - Path에서 File로 캐스팅
    ```java
    Path path = new File("sample.txt").toPath();
    ```
    - Path인스턴스 생성
    ```java
    Path path = Paths.get("dir/sample.txt");
    ```
- java.nio.file.Files : 파일 조작
    - File에서 Path로 캐스팅
    ```java
    File path = path.toFile();
    ```
    - File 실제파일 작성
    ```java
    // 경로에 파일이 이미 존재하면,
    // FileAlreadyExistsException 예외발생
    boolean isSuccess = Files.createFile(Paths.get("sample.txt"));
    ```
    - walk : 서브 디렉토리가 있을경우 재귀적으로 처리
    ```java
    Files.walk(base.resolve("src")).forEach(System.out::println);
    ```
    

#### Path클래스
- resolve 메서드 : Path를 인수로 받아 파일경로를 결합한다
```java
Path dir2 = Paths.get("dir", "subdir");
dir2.resolve(Paths.get("data.txt"));
// >> 결과 : dir/subdir/data.txt에 파일이 생성됨
```

#### Files클래스 파일의 이동과 복사
```java
// 파일 이동과 복사
Path originalFile = Paths.get("dir", "original.txt");
Path backupFile = Paths.get("dir", "backup.txt");
Path backupDir = Paths.get("dir", "subdir");
try {
    // 파일 복사 (파일 -> 파일)
    Files.copy(originalFile, backupFile);
    // 파일 이동 (파일 -> 디렉토리)
    Files.move(originalFile, backupDir);
} catch (Exception e) {}
```

#### BufferedWriter를 Append모드로 초기화
```java
BufferedWriter out = Files.newBufferedWriter(sample, StandardOpenOption.APPEND);
```

#### java.nio.file.FileVisitor 인터페이스
※파일 처리가 끝났을 때는 따로 이벤트가 없다
- preVisitDirectory : 디렉토리에 들어갔을 때 이벤트 처리
- postVisitDirectory : 디렉토리에서 나왔을 때 이벤트 처리
- visitFile : 파일에 조우했을 때
- visitFileFailed : 파일 처리에 실패했을 때

