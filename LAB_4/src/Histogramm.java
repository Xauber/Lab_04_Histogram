import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogramm {

	private Scanner scanner;
	private Scanner in;

	public static void main(String[] args) throws IOException {
		Histogramm h = new Histogramm();
		h.run();
	}

	public void run() throws IOException {
		String fileName = "C:/Users/maxde/Documents/Studium IMI/2.Semster/Info2/Labs/04_Histogram/WORK/Lab04_Histogramm/src/randomText200Words.txt.txt";
		File inputFile = new File(fileName);
		//scanner = new Scanner(inputFile);
		in = new Scanner(inputFile);

		//scanner.useDelimiter("\\r|\\n|");
		//scanner.useDelimiter("");
		int[] counter = new int[128];
		while(in.hasNextLine()) {
			String nextLine = in.nextLine();
			scanner = new Scanner(nextLine);
			scanner.useDelimiter("");
			while(scanner.hasNext()) {
				char ch = characterReturn();
				//System.out.println(scanner.next());
				ch = normalize(ch);
				counter[ch] = counter[ch] + 1;
			}
			
		    }
		int highest = 0;
		int scale = 100;
		for (int i = 0; i < counter.length; i++) {
	    	highest = Math.max(highest, counter[i]);
	    	}
		//System.out.println(highest);
		ArrayList<String> print = new ArrayList<>(); 
		for (int i = 0; i < counter.length; i++) {
	    	if(counter[i] > 0 || (i>= 97 && i<=122) ) {
	    	char c = (char) i;
	    	int value = counter[i]*scale/highest;
	    	String output = c + " ";
	    	for (int y =0; y < value; y++) {
	    		if(y%5 == 0 && y != 0) {
	    			output += "|";
	    		}
	    		output += "*";
	    	}
			//System.out.println(output);
	    	print.add(output + "\n");
	    	}
		}
	writeFile(print, "frequency.txt");	
		


	}

	public char characterReturn() {
		return scanner.next().charAt(0);
	}
	
	public void writeFile(ArrayList<String> input, String filename) throws IOException {
		File newFile = new File(filename);
		FileWriter writer = new FileWriter(filename);
	    newFile.createNewFile();
	    for (String text: input) {
	    	writer.write(text);
	    }
	    writer.close();
	}
	
	public char normalize(char a){
		if(a >= 65 && a <= 90){
			int b = a + 32;
			return (char)b;
		} else {
			return (char)a;
		}
	}
}
