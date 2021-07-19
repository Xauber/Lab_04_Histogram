import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class ReadNext {
	
	public ArrayList<Integer> frequency;
	public ArrayList<Character> fileCharacters;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("/Users/benedictlippold/Desktop/Lab_04/alice30.txt");
		Scanner scanner = new Scanner(file);
		ArrayList<Integer>fileCharacters = new ArrayList<>();
		
		while(scanner.hasNext()) {
			String s = scanner.next();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				fileCharacters.add(c);
			}
		}
		
		while(scanner.hasNextLine()) {
			fileContent = fileContent.concat(scanner.nextLine() + "\n");
		}
		
		FileWriter writer = new FileWriter("/Users/benedictlippold/Desktop/Lab_04/newFile.txt");
		writer.write(fileContent);
		writer.close();
	}
	
	public void countCharacters() {
	int[] charCounts = {25}; //letters only for now
	for(int i=0; i<fileCharacters.size(); i++) {
		char c = fileCharacters.get(i);
		if (c >= 65 && c<= 90 || c >= 97 && c <= 122) {
			setToUpperCase();
			charCounts[c - 65] = charCounts[c-65] + 1;
			}
		}
		
	}

}
