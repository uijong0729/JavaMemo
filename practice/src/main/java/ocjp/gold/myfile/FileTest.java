package ocjp.gold.myfile;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        // 디렉토리 내 일람을 File로서 가져오는 메소드 listFiles
        File dir = new File(".");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
