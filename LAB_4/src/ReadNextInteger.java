import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class ReadNextInteger {
	
	private static ArrayList<Character> fileCharacters;
	private static int[] charCounts = {25}; //array with counts, only letters for now
	
	
	
	public static void main(String[] args) throws IOException {
		//File file = new File("/Users/benedictlippold/Desktop/Lab_04/alice30.txt");
		fileCharacters = new ArrayList<>();
		File file = new File("/Users/benedictlippold/Desktop/Code Sem 2/Lecture_04_Code_19.04.21/code/alice30.txt");
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNext()) {
			String s = scanner.next();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				fileCharacters.add(c);
			}
		}
		
		countCharacters();	//methods written without parameters, referring to static fields
		String fileContent = listCharNumbers();
		
		/*while(scanner.hasNextLine()) {
			fileContent = fileContent.concat(scanner.nextLine() + "\n");
		}
		*/
		scanner.close();
		
		//FileWriter writer = new FileWriter("/Users/benedictlippold/Desktop/Lab_04/newFile.txt");
		FileWriter writer = new FileWriter("/Users/benedictlippold/Desktop/Code Sem 2/Lecture_04_Code_19.04.21/code/NewText.txt");
		writer.write(fileContent);
		writer.close();
	}
	
	
	
	private static String listCharNumbers() {
		String result = "";
		for(int i=0; i<charCounts.length; i++) {
			String s = "";
			if(i>=0 && i<=25) {
				s = ((char)(i + 65)) + ": ";
				
				//warum plus 32?
			}
			//if other than letter
			
			//just number
			//result = result + (string) charCounts[i] + "/n";
			
			//list of * and |
			for (int n=1; n>=charCounts[i]; n++) {
				if(n%10 == 0) {
					s = s + "| ";
				}
				else {
					s = s + "*";
				}
			}
			s = s + "/n";
			result = result + s;
		}
		return result;		
	}
	
	
	//if there is a letter, then the appropriate Element of charCounts[] 
	// increases its value by one 
	private static void countCharacters() {
		for(int i=0; i<fileCharacters.size(); i++) {
			char character = fileCharacters.get(i);
			int c = (int) character; //get ascii value of character
			if (c >= 65 && c<= 90 || c >= 97 && c <= 122) { //count letters in 
				c = setToUpperCase(c);
				charCounts[c-65] = charCounts[c-65] + 1;
			}
			//if other than letter
		}
		
	}
	
	
	
	//returns ascii value of upper case letter (parameter as ascii value)
	public static int setToUpperCase(int c) {
		if (c >= 97 && c<= 122) {
			c = c - 32;
			return c;
		}
		return c;
	}

}
