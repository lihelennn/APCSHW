import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    private int rows;
    private int cols;
   
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	int placeR = 0;
	int placeC = 0;
	data = new char[rows][cols];
	this.rows = rows;
	this.cols = cols;
	while (placeR < rows){
	    while (placeC < cols){
		data[placeR][placeC] = ' ';
		placeC += 1;
	    }
	    placeR += 1;
	    placeC = 0;
	}
    }

    private int getRows(){
	return rows;
    }

    private int getCols(){
	return cols;
    }


    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	int placeR = 0;
	int placeC = 0;
	while (placeR < rows){
	    while (placeC < cols){
		data[placeR][placeC] = ' ';
		placeC += 1;
	    }
	    placeR += 1;
	    placeC = 0;
	}
    }
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	int placeR = 0;
	int placeC = 0;
	String str = "";
	while (placeR < rows){
	    while (placeC < cols){
		str += data[placeR][placeC] + " ";
		placeC += 1;
	    }
	    placeR += 1;
	    str += "\n";
	    placeC = 0;
	}
	return str;
    }


  

    public boolean checkWord(String word, int row, int col, int dy, int dx){
	if (dy == 0 && dx == 0){
	    return false;
	}else{
	    if (row < 0 || col < 0){
		return false;
	    }else{
		if (col + (dx * word.length()) < 0 || col + (dx * word.length()) >= cols || row + (dy * word.length()) < 0 || row + (dy * word.length()) >= rows){
		    return false;
		}else{
		    return true;
		}
	    }
	}
    }

    public boolean addWord(String word, int row, int col, int dy, int dx){
	int place = 0;
	int origRow = row;
	int origCol = col;
	if (checkWord(word, row, col, dy, dx) == true){
	    while (place < word.length()){
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (col < cols && row < rows && place < word.length()){
			if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
			    place += 1;
			    row += dy;
			    col += dx;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    row = origRow;
		    col = origCol;
		    while (col < cols && row < rows && place < word.length()){
			data[row][col] = word.charAt(place);
			place += 1;
			row += dy;
			col += dx;
		    }
		    return true;
		}
		place += 1;
	    }
	}
	return false;
    }
    


















	  


    public static void main (String[]args) throws FileNotFoundException{
	WordGrid test1 = new WordGrid(15, 15);
	ArrayList<String> wordList = new ArrayList<String>();
	Random r1 = new Random();
	Random c1 = new Random();
	Random d1 = new Random();
	Random dy2 = new Random();
	Random dx2 = new Random();
	int count = 0;
	File text = new File("C:/Users/Helen/Documents/GitHub/APCSHW/APCSHW/03wordsearch/words.txt");
	Scanner sc = new Scanner(text);
	while (sc.hasNextLine()){
	    wordList.add(sc.nextLine());
	}
	int place = 0;
	while (place < wordList.size()){
	    boolean goOn = false;
	    String line = wordList.get(place);	
	    count = 0;
	    while (goOn == false && count < 5){
		if (test1.addWord(line , r1.nextInt(test1.getRows()) , c1.nextInt(test1.getCols()) , dy2.nextInt(3) - 1 , dx2.nextInt(3) - 1) == false){
		    count += 1;
		}else{
		    goOn = true;
		}
       	    }
	    count = 0;
	    place += 1;
	}	   
        System.out.println(test1);
    
    }
}
