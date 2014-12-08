import java.util.*;

public class Demo{

    public static void main(String[]args) throws IndexOutOfBoundsException{
	try{
	    if (args[0].equals("selectionSort") || args[0].equals("insertionSort")){
		long startTime = System.currentTimeMillis();
		SuperArray tester = new SuperArray(1000);
		int place = 0;
		while (place < 1000){
		    tester.add(Integer.toString(place));
		    place += 1;
		}
		// System.out.println(tester);
	    		
		if (args[0].equals("selectionSort")){
		    tester.selectionSort();
		    long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    System.out.println("InsertionSort Done. It took : " + elapsedTime + " milliseconds.");

		}else{
		    if (args[0].equals("insertionSort")){
			tester.insertionSort();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("InsertionSort Done. It took : " + elapsedTime + " milliseconds.");

		    }
		}
	    }else{        
		if (args[0].equals("arraysSort")){
		    long startTime = System.currentTimeMillis();
		    int place2 = 0;
		    String[] tester2 = new String[500000];
		    while (place2 < tester2.length){
			tester2[place2] = (Integer.toString(place2));
			place2 += 1;
		    }
		    Arrays.sort(tester2);
		    long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    System.out.println("ArraysSort Done. It took : " + elapsedTime + " milliseconds.");

		    // System.out.println(Arrays.toString(tester2));
		    // int place2 = 0;
		    // String ans = "[";
		    // while (place2 < tester2.length){
		    //     ans += tester2[place];
		    //     place2 += 1;
		    // }
		    // ans += "]";
		    // System.out.println(ans);

		}else{
		    System.out.println("Please input selectionSort, insertionSort, or arraysSort.");
		}		    
	    }
	}
    	catch (IndexOutOfBoundsException e){
	    System.out.println("Please input selectionSort, insertionSort, or arraysSort.");
	}
    }
}
			       
