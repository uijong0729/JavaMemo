import java.io.File;

import file.FileSimpleManager;
import reflection.CreateResultMap;

public class TestCodeExecutor {

	public static void main(String[] args) {
		//String filepath = System.getProperty("user.dir") + "/test.txt";
		//FileSimpleManager.makeTextFile(filepath, "text");
		//FileSimpleManager.readTextFile(filepath);
		
		CreateResultMap map = new CreateResultMap();
		System.out.println(map.getFields("VARCHAR"));
	}

}
