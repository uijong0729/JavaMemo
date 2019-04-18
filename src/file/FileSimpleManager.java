package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileSimpleManager {

    public static String readTextFile(String filepath) {
    	File file = new File(filepath);
    	file.setReadable(true);

    	StringBuffer sb = new StringBuffer();
    	try(FileInputStream fis = new FileInputStream(file);
    			BufferedReader br = new BufferedReader(new InputStreamReader(fis));){
    		
    		for(String str = br.readLine(); str != null ; str = br.readLine()) {
                sb.append(str + "\n");
            }
    		
    	} catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void makeTextFile(String filepath, String text) {
    	File file = new File(filepath);
    	file.getParentFile().mkdirs();
    	if(!file.exists()) {
    		try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	file.setWritable(true);
    	
        try (FileOutputStream fos = new FileOutputStream(file);) {
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
