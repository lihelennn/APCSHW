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
		System.out.println(word.charAt(place));
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
		System.out.println(word.charAt(place));
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
		System.out.println(word.charAt(place));
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
		System.out.println(word.charAt(place));
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



    public static void main (String[]args) throws FileNotFoundException{
	WordGrid test1 = new WordGrid(20, 20);
	Random r1 = new Random();
	Random c1 = new Random();
	Random d1 = new Random();
	int count = 0;

	File text = new File("C:/Users/Helen/Documents/GitHub/APCSHW/APCSHW/03wordsearch/words.txt");
	Scanner sc = new Scanner(text);
	while (sc.hasNextLine()){
	    boolean goOn = false;
	    String line = sc.nextLine();
	    count = 0;
	    int row = r1.nextInt(test1.getRows());
	    int col = c1.nextInt(test1.getCols());
	    int  dir = d1.nextInt(8);
	    while (goOn == false && count < 50){
		if (dir == 0){
		    goOn = test1.addWordHorizontal(line, row, col);
		}else{
		    if (dir == 1){
			goOn = test1.addWordHorizontal2(line, row, col);
		    }else{
			if (dir == 2){
			    goOn = test1.addWordVertical(line, row, col);
			}else{
			    if (dir == 3){
				goOn = test1.addWordVertical2(line, row, col);
			    }else{
				if (dir == 4){
				    goOn = test1.addWordDiagonal(line, row, col);
				}else{
				    if (dir == 5){
					goOn = test1.addWordDiagonal2(line, row, col);
				    }else{
					if (dir == 6){
					    goOn = test1.addWordDiagonal3(line, row, col);
					}else{
					    goOn = test1.addWordDiagonal4(line, row, col);
					}
				    }
				}
			    }
			}
		    }
		}
		count += 1;
	    }
	}   


	



	System.out.println(test1);
	//	System.out.println(test1.addWordHorizontal2("happy", 5, 5)); 
	//	System.out.println(test1.addWordHorizontal("hay", 0, 1)); 
	//	System.out.println(test1.addWordHorizontal("meet", 1, 1)); 
	//	System.out.println(test1.addWordHorizontal("hater", 2, 1)); 
	//	System.out.println(test1.addWordVertical2("apcs", 1, 2)); 
	//	System.out.println(test1.addWordVertical("hello", 2, 4)); 
	//	System.out.println(test1.addWordVertical("helloooo", 3, 4)); 
	//	System.out.println(test1.addWordHorizontal("woof", 3, 1)); // expect false; cannot fit;
	//	System.out.println(test1.addWordHorizontal("woof", 3, 0)); // expect true; should fit
	//	System.out.println(test1.addWordDiagonal("math", 1, 1));
	//	System.out.println(test1.addWordDiagonal3("helen", 1, 5));
    }
}
