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


  

    private static String reverseString(String str){
	int leng = str.length();
	int place = leng - 1;
	while (place >= 0){
	    str += str.charAt(place);
	    place -= 1;
	}
	str = str.substring(leng, str.length());
	return str;
    }
	   
		   
	   
	  


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word, int row, int col){
	int place = 0;
	int origCol = col;
	int origCol2 = col;
	if (col + word.length() - 1 > cols){
	    return false;
	}else{
	    while (place < word.length() && col < cols){
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (origCol < cols && place < word.length()){
			if (data[row][origCol] == word.charAt(place) || data[row][origCol] == ' '){
			    place += 1;
			    origCol += 1;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    origCol = origCol2;
		    while (origCol < cols && place < word.length()){
			data[row][origCol] = word.charAt(place);
			place += 1;
			origCol += 1;
		    }
		    return true;
		}
		
		place += 1;
		col += 1;
	    }
	    return false;
	}
    }
    
    public boolean addWordVertical(String word, int row, int col){
	int place = 0;
	int origRow = row;
	int origRow2 = row;
	if (row + word.length() - 1 > rows){
	    return false;
	}else{
	    while (place < word.length() && row < rows){
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (origRow < rows && place < word.length()){
			if (data[origRow][col] == word.charAt(place) || data[origRow][col] == ' '){
			    place += 1;
			    origRow += 1;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    origRow = origRow2;
		    while (origRow < rows && place < word.length()){
			data[origRow][col] = word.charAt(place);
			place += 1;
			origRow += 1;
		    }
		    return true;
		}
		
		place += 1;
		row += 1;
	    }
	    return false;
	}
    }
    

    //vertical + diagonal should be implemented as well.




    public boolean addWordDiagonal(String word, int row, int col){
	int place = 0;
	int origDiaR = row;
	int origDiaR2 = row;
	int origDiaC = col;
	int origDiaC2 = col;
	if (row + word.length() - 1 > rows || col + word.length() - 1 > cols){
	    return false;
	}else{
	    while (place < word.length() && row < rows && col < cols){
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (origDiaC < cols && origDiaR < rows && place < word.length()){
			if (data[origDiaR][origDiaC] == word.charAt(place) || data[origDiaR][origDiaC] == ' '){
			    place += 1;
			    origDiaR += 1;
			    origDiaC += 1;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    origDiaR = origDiaR2;
		    origDiaC = origDiaC2;
		    while (origDiaC < cols && origDiaR < rows && place < word.length()){
			data[origDiaR][origDiaC] = word.charAt(place);
			place += 1;
			origDiaR += 1;
			origDiaC += 1;
		    }
		    return true;
		}
		
		place += 1;
		row += 1;
		col += 1;
	    }
	    return false;
	}
    }
    

    public boolean addWordDiagonal2(String word, int row, int col){
	int place = 0;
	int origDiaR = row;
	int origDiaR2 = row;
	int origDiaC = col;
	int origDiaC2 = col;
	if (row + word.length() - 1 > rows || col - word.length() < 0){
	    return false;
	}else{
	    while (place < word.length() && row < rows && col >= 0){
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (origDiaC >= 0 && origDiaR < rows && place < word.length()){
			if (data[origDiaR][origDiaC] == word.charAt(place) || data[origDiaR][origDiaC] == ' '){
			    place += 1;
			    origDiaR += 1;
			    origDiaC -= 1;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    origDiaR = origDiaR2;
		    origDiaC = origDiaC2;
		    while (origDiaC >= 0 && origDiaR < rows && place < word.length()){
			data[origDiaR][origDiaC] = word.charAt(place);
			place += 1;
			origDiaR += 1;
			origDiaC -= 1;
		    }
		    return true;
		}
		
		place += 1;
		row += 1;
		col -= 1;
	    }
	    return false;
	}
    }
    

    public boolean addWordHorizontal2(String word, int row, int col){
	word = reverseString(word);
	return addWordHorizontal(word, row, col);
    }

    public boolean addWordVertical2(String word, int row, int col){
	word = reverseString(word);
	return addWordVertical(word, row, col);
    }

    public boolean addWordDiagonal3(String word, int row, int col){
	word = reverseString(word);
	return addWordDiagonal(word, row, col);
    }

    public boolean addWordDiagonal4(String word, int row, int col){
	word = reverseString(word);
	return addWordDiagonal2(word, row, col);
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
	    while (goOn == false && count < 20){
		test1.addWord(wordList.get(place) , r1.nextInt(test1.getRows()) , c1.nextInt(test1.getCols()) , dy2.nextInt(3) - 1 , dx2.nextInt(3) - 1);
		count += 1;
	    }
	    count = 0;
	    place += 1;
	}
	   
	


	



	System.out.println(test1);
       
    }
}
