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