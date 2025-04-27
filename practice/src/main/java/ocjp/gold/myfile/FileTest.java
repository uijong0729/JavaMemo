package ocjp.gold.myfile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {
    public static void main(String[] args) {
        // 디렉토리 내 일람을 File로서 가져오는 메소드 listFiles
        File dir = new File(".");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }

        // resolve 결과 : dir/subdir/data.txt에 파일이 생성됨
        Path dir2 = Paths.get("dir", "subdir");
        dir2.resolve(Paths.get("data.txt"));

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
    }
}
