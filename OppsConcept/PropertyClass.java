package OppsConcept;

import java.io.FileReader;
import java.util.Properties;

public class PropertyClass {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:\\Users\\jagat\\eclipse-workspace\\JavaPractise\\src\\OppsConcept\\Info.properties");
		Properties properties = new Properties();
		properties.load(reader);
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));
		System.out.println(properties.getProperty("you"));
		properties.setProperty("Mango", "yellow");
		System.out.println();
	}

}
