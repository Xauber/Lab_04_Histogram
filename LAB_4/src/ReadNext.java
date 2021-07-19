import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ReadNext {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("/Users/benedictlippold/Desktop/Lab_04/alice30.txt");
		Scanner scanner = new Scanner(file);
		String fileContent = " ";
		
		while(scanner.hasNextLine()) {
			fileContent = fileContent.concat(scanner.nextLine() + "\n");
		}
		
		FileWriter writer = new FileWriter("/Users/benedictlippold/Desktop/Lab_04/newFile.txt");
		writer.write(fileContent);
		writer.close();
	}

}
