package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayConverter {

    public  File byteArrayToFile(byte[] blob, String path){
        File file = new File(path);
        try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(blob);
                fos.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public  File inputStreamToFile(InputStream is, String path){
        File file = new File(path);
        try {
            OutputStream os = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = is.read(buf)) > 0){
                os.write(buf, 0, len);
            }
            os.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public byte[] convertByteArray(String filePath) {
        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;
        try {
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytesArray;
    }
}
