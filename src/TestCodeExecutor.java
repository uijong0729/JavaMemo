import gui.MakeTextArea;
import reflection.ResultMap;

public class TestCodeExecutor {

	public static void main(String[] args) {
		//String filepath = System.getProperty("user.dir") + "/test.txt";
		//FileSimpleManager.makeTextFile(filepath, "text");
		//FileSimpleManager.readTextFile(filepath);

		ResultMap map = new ResultMap();
		System.out.println(map.getFields("VARCHAR"));

		MakeTextArea.showTextArea(map.getFields("VARCHAR"));
	}

}
