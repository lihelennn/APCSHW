import java.util.*;

public class Driver{

    public static void main(String[]args){
	int[] tester1 = new int[100000];
	int[] tester2 = new int[100000];
	int[] tester3 = new int[100000];
	int[] tester4 = new int[100000];
	int[] tester5 = new int[100000];

	int place = 0;
	Random rand = new Random();
	while (place < 100000){
	    tester1[place] = rand.nextInt(Integer.MAX_VALUE);
	    tester2[place] = rand.nextInt(Integer.MAX_VALUE);	   
	    tester3[place] = rand.nextInt(Integer.MAX_VALUE);
	    tester4[place] = rand.nextInt(Integer.MAX_VALUE);
	    tester5[place] = rand.nextInt(Integer.MAX_VALUE);
	    place += 1;
	}

	long startTime, endTime;

	startTime = System.currentTimeMillis();
	Sorts.bubble(tester1);
	endTime = System.currentTimeMillis();
	System.out.println("bubble: " + (endTime - startTime));


	startTime = System.currentTimeMillis();
	Sorts.selection(tester2);
	endTime = System.currentTimeMillis();
	System.out.println("selection: " + (endTime - startTime));


	startTime = System.currentTimeMillis();
	Sorts.insertion(tester3);
	endTime = System.currentTimeMillis();
	System.out.println("insertion: " + (endTime - startTime));


	startTime = System.currentTimeMillis();
        Arrays.sort(tester4);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort built-in: " + (endTime - startTime));

	startTime = System.currentTimeMillis();
	Sorts.radix(tester5);
	endTime = System.currentTimeMillis();
	System.out.println("radix: " + (endTime - startTime));

    }
}
