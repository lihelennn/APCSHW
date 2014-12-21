import java.util.*;

public class Sorts{

    // public String toString(){
    // 	int place = 0;
    // 	String answer = "[";
    // 	while (place < data.length && data[place] != null){
    // 	    answer += ("" + data[place] + " ");
    // 	    place += 1;
	    
    // 	}
    // 	answer += "]";
    // 	return answer;
    // }

    public static void selection(int[] c){
	int place = 0;
	int GoTo = 0;
	int smallestInd = 0;
	int swapped = 0;
	while (place < c.length){
	    while (GoTo < c.length){
		if (c[place] - c[GoTo] > 0 && c[GoTo] - c[smallestInd] < 0){
		    // System.out.println(get(place) + "compareTo " + get(GoTo) + "= " + get(place).compareTo(get(GoTo)));			
		    smallestInd = GoTo;
		    // System.out.println("GoTo = " + GoTo);
		}
		GoTo += 1;
	    }
	    swapped = c[place];
	    c[place] = c[smallestInd];
	    c[smallestInd] = swapped;
	    place += 1;
	    GoTo = place;
	    smallestInd = place;
	}
	// int place3 = 0;
	// String answer = "[";
	// while (place3 < c.length){
	//     answer += ("" + c[place3] + " ");
	//     place3 += 1;
	    
	// }
	// answer += "]";
	// System.out.println(answer);
    }

    public static void insertion(int[] c){
    	int place = 1;
	int origPlace = 1;
    	int place2 = 0;
    	int old = 0;
    	int orig = 0;
    	while (place < c.length){
    	    // old = c[place];
 	    //	    System.out.println(this);
    	    if (c[place - 1] - c[place] >= 0){
		orig = c[place];
    		while (place2 >= 0){
		    // System.out.println(orig);
    		    if (orig - c[place2] <= 0){
			c[place] = c[place2];
			if (place2 == 0){
			    c[place2] = orig;		
			}
		    }else{
			c[place] = orig;
			place2 = -1;		   
		    }
		    place -= 1;
		    place2 -= 1;
		}
	    }
	    orig = 0;
	    origPlace += 1;
	    place = origPlace;
	    place2 = place - 1;
	}
	// int place3 = 0;
	// String answer = "[";
	// while (place3 < c.length){
	//     answer += ("" + c[place3] + " ");
	//     place3 += 1;
	    
	// }
	// answer += "]";
	// System.out.println(answer);
    }

	        

    public static void bubble(int[] c){
	int count = 0; // count if no swaps the time before
	int place = 0;
	int place2 = 0;
	int store = 0;
	while (place < c.length - 1){
	    while (place2 < c.length - 1){
		if (c[place2] > c[place2 + 1]){
		    store = c[place2];
		    c[place2] = c[place2 + 1];
		    c[place2 + 1] = store;
		    count += 1;
		}
		place2 += 1;
	    }
	    if (count == 0){
		break;
	    }
	    count = 0;
	    place2 = 0;
	    place += 1;
	}
	// int place3 = 0;
	// String answer = "[";
	// while (place3 < c.length){
	//     answer += ("" + c[place3] + " ");
	//     place3 += 1;
	    
	// }
	// answer += "]";
	// System.out.println(answer);
    }

    public static void radix(int[] c){
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
	int place = 0;
	int bucketPlace = 0;
	int bucketPlaceInner = 0;
	int digit = 1;
	int digitSave = digit;
	int number = 0;
	int largestBeg = 0;
	int mostGen = 0;
	int init = 0;
	ArrayList<Integer> initList = new ArrayList<Integer>();

	while (mostGen < c.length - 1){
	    initList.clear();
	    init = 0;
	    initList.add(0);
	    while (init < 10){
		bucket.add(init, initList);
		init += 1;
	    }

	    if ((c[mostGen] / (Math.pow(10, digit - 1))) != 0){ 
		while (place < c.length){ // add to buckets
		    // while (digit > 1){
		    //     number = c[place] / 10;
		    // 	digit -= 1;
		    // }

		    number = ((int)((c[place]) / (Math.pow(10, digit - 1))) % 10);
		    System.out.println(number);
		    // System.out.println(number);
		    initList.clear();
		    initList.add(c[place]);
		    bucket.add(number, initList);
		    place += 1;
		    initList.clear();
		}   	       
		place = 0;
		while (bucketPlace < bucket.size() && bucket.get(bucketPlace) != null){ // add back to int[]c
			initList = bucket.get(bucketPlace);
		    while (place < c.length && bucketPlaceInner < bucket.get(bucketPlace).size()){
			c[place] = initList.get(bucketPlaceInner);
			bucketPlaceInner += 1;
			place += 1;
		    }
		    bucketPlace += 1;
		}
		place = 0;
		digitSave += 1;
		digit = digitSave;
		bucketPlace = 0;
		bucketPlaceInner = 0;
		bucket.clear();
	    }
	    mostGen += 1;
	    int place3 = 0;
	    String answer = "[";
	    while (place3 < c.length){
		answer += ("" + c[place3] + " ");
		place3 += 1;
	    
	    }
	    answer += "]";
	    System.out.println(answer);
	}
    }













    public static void main(String[]args){
	int[]tester = new int[10];
	int place = 0;
	Random rand = new Random();
	while (place < tester.length){
	    tester[place] = rand.nextInt(100);
	    place += 1;
	}
	int place3 = 0;
	String answer = "[";
	while (place3 < tester.length){
	    answer += ("" + tester[place3] + " ");
	    place3 += 1;
	    
	}
	answer += "]";
	System.out.println(answer);

	radix(tester);
	// bubble(tester);
	// selection(tester);
	// insertion(tester);
	answer = "[";
	place3 = 0;
	while (place3 < tester.length){
	    answer += ("" + tester[place3] + " ");
	    place3 += 1;
	    
	}
	answer += "]";
	System.out.println(answer);

    }

}
