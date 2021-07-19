import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Histogram2 {
	
	private static ArrayList<Character> fileCharacters;
	private static int[] charCounts; //array with counts, only letters for now
	
	public static void main(String[] args) throws IOException {
		
	//Initialize fields
		
		fileCharacters = new ArrayList<>();
		charCounts = new int[28]; //26 is size 1,2,...,26 ; not starting with 0, 1, 2, ... 25 //26 letters + 1 Leerzeichen
		
	//Scan file
		
		//File file = new File("/Users/benedictlippold/Desktop/Lab_04/alice30.txt");
		//File file = new File("C:/Users/Wolfsmond/Documents/Studium/Medieninformatik_Studium/2.Sem/Informatik2/test-file.txt");
		File file = new File("/Users/benedictlippold/Desktop/Lab_04/Test1.txt");
		
		Scanner scanner = new Scanner(file);
		
	//Add characters of file to an ArrayList	
		
		//spaces not added to fileCharacters with hasNext() and next(), since space works as a character separating the tokens (Strings/Words)
		//while(scanner.hasNext()) {
		//String s = scanner.next();		
	
		//spaces added to ArrayList with hasNextLine() and nextLine()
		while(scanner.hasNextLine()) {
			String s = scanner.nextLine();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				fileCharacters.add(c);   //N
			}
		}
		scanner.close();
		
	//count and sort all characters and write them into a single String	
		countCharacters();	//methods written without parameters, refering to static fields //N
		String fileContent = listCharNumbers();
		
	//Write to new file
		
		//FileWriter writer = new FileWriter("/Users/benedictlippold/Desktop/Lab_04/newFile.txt");
		//FileWriter writer = new FileWriter("C:/Users/Wolfsmond/Documents/Studium/Medieninformatik_Studium/2.Sem/Informatik2/Labs/Lab4/newFile_letterCounter.txt");
		FileWriter writer = new FileWriter("/Users/benedictlippold/Desktop/Lab_04/Test_letterCount.txt");
		
		writer.write(fileContent);
		writer.close();
	}
	
	//visualize counted characters //N
	private static String listCharNumbers() {
		String result = "";
		for(int i=0; i<charCounts.length; i++) {
			String s = "";
			//for letters:
			if(i>=0 && i<=25) {
				s = ((char)(i + 65)) + ": "; //write corresponding letter in front of the line
			}
			//for characters other than letters:
			if(i==26) {
				s = s + "Space: ";
			}
			if(i==27) {
				s = s + "Full Stops: ";
			}
			
			//list of * and |
			for (int n=1; n<=charCounts[i]; n++) { // A: ***** ****| * ***** ****| ***** ****|
				s = s + "*";
				if(n%10 == 0) {
					s = s + "| ";
				}
			}
			//add number counting the character to String
			s = s + " Letter Count: " + charCounts[i];
			
			s = s + "\n"; //new line for next character
			
			//add created line to final result String
			result = result + s;
		}
		return result;		
	}
	
	//count how often each character (for now just letters, space, dot) appear in ArrayList (aka scanned .txt)
	private static void countCharacters() {
		for(int i=0; i<fileCharacters.size(); i++) {
			char character = fileCharacters.get(i);
			int c = (int) character; //get ascii value of character
			if (c >= 65 && c<= 90 || c >= 97 && c <= 122) { //if letter
				c = setToUpperCase(c);
				c = c-65; //set char value to one fitting as array index
				charCounts[c] = charCounts[c] + 1; //increase value of position in array corresponding with letter
			}
			//if other than letter //space can't be counted because it separates Strings when using scanner.next()
			if (c == 32) { //space
				charCounts[26] = charCounts[26] + 1;
			}
			if (c == 46) { //full stop.
				charCounts[27] = charCounts[27] + 1;
			}
		}
		
	}
	
	//returns ascii value of upper case letter (parameter as ascii value)
	public static int setToUpperCase(int c) {
		if (c >= 97 && c<= 122) { //if lower case letter
			c = c - 32; //ascii to upper case letter
			return c;
		}
		return c;
	}

}
