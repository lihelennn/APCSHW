public class Sorts{

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
	    set(smallestInd, swapped);
	    place += 1;
	    GoTo = place;
	    smallestInd = place;
	}
	// System.out.println("selectionSort complete.");
    }

    public static void insertion(int[] c){
	int place = 1;
	int place2 = 0;
	String old = "";
	String orig = "";
	while (place < size()){
	    old = get(place);
	    //	    System.out.println(this);
	    if (get(place - 1).compareTo(get(place)) >= 0){
		while (place2 >= 0){
		    if (get(place).compareTo(get(place2)) <= 0){
			while (place2 <= place){
			    old = set(place2 , old);
			    place2 += 1;
			}
			place2 = -10;
      		    }	
		    place2 += 1;	    
		}
	    }
	    place += 1;
	    place2 = 0;
	}
	// System.out.println("insertionSort complete.");
    }

    public static void bubble(int[] c){
	int place = 0;
	int place2 = 0;
	int store = 0;
	while (place < c.length - 1){
	    while (place2 < c.length - 1){
		if (c[place2] > c[place2 + 1]){
		    store = c[place2];
		    c[place2] = c[place2 + 1];
		    c[place2 + 1] = store;
		}
		place2 += 1;
	    }
	    place2 = 0;
	    place += 1;
	}
    }

