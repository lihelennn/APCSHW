import java.util.*;
import java.io.*;
import java.nio.*;

public class ReadFile{

    public static void main (String[]args) throws FileNotFoundException{
	File text = new File("words.txt");
	Scanner sc = new Scanner(text).useDelimiter(" ");
	while (sc.hasNextLine()){
	    String line = sc.nextLine();
	    System.out.println(line);
	}

    }
}
