import java.util.*;

public class SuperArray{

    String[]data;
    int currentNumber;

    public void leftJustify(){
	int place = 0;
	int place2 = 0;
	String[]obj2 = new String[data.length];
	while (place < data.length){
	    if (data[place] != null){
		obj2[place2] = data[place];
		place2 += 1;
	    }
	    place += 1;
	}
	data = obj2;
    }
    public void setCurrentNumber(int length){
	currentNumber = length;
    }
    public int getFullLength(){
	return data.length;
    }
    public SuperArray(){
	data = new String[10];
	System.out.println("Default array created");
    }
    public SuperArray(int length){
	data = new String[length];
	System.out.println("Array created");
    }
    public String toString(){
	int place = 0;
	String answer = "[";
	while (place < data.length){
	    answer += ("" + data[place] + " ");
	    place += 1;
	}
	answer += "]";
	return answer;
    }
    public int size(){
	int sizee = 0;
	int place = 0;
	while (place < data.length){
	    if (data[place] != (null)){
		sizee += 1;
	    }
	    place += 1;
	}
	if (sizee > 0){
	    currentNumber = sizee - 1;
	}else{
	    currentNumber = sizee;
	}
	return sizee;
    }
    public void resize(int newCapacity){
	String[]data2 = new String[newCapacity];
	int place = 0;
	while (place < data.length){
	    data2[place] = data[place];
	    place += 1;
	}
	data = data2;
    }
    //    public void add(String e){
    //	if (currentNumber < data.length){
    //	    data[currentNumber] = e;
    //    currentNumber += 1;
    //	}else{
    //   resize(data.length * 2);
    //    data[currentNumber] = e;
    //   currentNumber += 1;
    //   }
    //	currentNumber += 1;
    //	leftJustify();
    // }

    public void add(String e){ 
	//looked at your code to fix some stuff because mine was previously too complicated.
	if (size() == data.length){
	    resize(size() * 2);
	}
	currentNumber += 1;
	data[currentNumber] = e;
	currentNumber += 1;
	leftJustify();
    }
    public void clear(){
	String[]data2 = new String[data.length];
	data = data2;
    }
    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    return "" + data[index];
	}
    }
    public String set(int index, String e){ //changed for insertionSort method (changing nulls to something, so size() cannot throw exception)
	String old;
	if (index < 0 || index >= data.length){
	    throw new IndexOutOfBoundsException();
	}else{
	    old = data[index];
	    data[index] = e;
	    leftJustify();
	    return old;
	}
    }


    public void add(int index, String o){ 
	//referenced your code because my code was breaking for this function. I looked at how you scanned through the index by going down instead of going up.
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (size() == data.length){
	    resize(size() * 2);
	}
	int place = data.length - 1;
	while (place > index){
	    data[place] = data[place - 1];
	    place -= 1;
	}
	data[index] = o;
	currentNumber += 1;
	leftJustify();
    }


    //	    while (place < index){
    //		data2[place] = data[place];
    //		place += 1;
    //	    }
    //	    if (place == index){
    //		data2[index] = o;
    //		index += 1;
    //	    }
    //	    while (place < size()){
    //		data2[index] = data[place];
    //		place += 1;
    //		index += 1;
    //	    }
    //	    data = data2;
    //    leftJustify();
    //}
    //currentNumber += 1;
    //}


    public String remove (int index){
	int place = 0;
	String removed = null;
	String[]data2 = null;
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    place = 0;
	    if (size() <= data.length / 4){
		data2 = new String[data.length / 2];
	    }else{
		data2 = new String[data.length];
	    }
	    while (place < index){
		data2[place] = data[place];
		place += 1;
	    }
	    if (place == index){
		removed = data[index];
		index += 1;
	    }
	    while (index < size()){
		data2[place] = data[index];
		place += 1;
		index += 1;
	    }
	    data = data2;
	    leftJustify();
	}
	currentNumber -= 1;
	return removed;
    }

    public void insertionSort(){
	int place = 1;
	int place2 = 0;
	String orig = "";
	String old = "";
	while (place < size()){
	    if (get(place - 1).compareTo(get(place)) >= 0){
		orig = remove(place);	
		while (place2 < size() - 1){
		    if ((place2 == 0 && orig.compareTo(get(0)) <= 0) || (place2 != 0 && orig.compareTo(get(place2 - 1)) >= 0 && orig.compareTo(get(place2)) <= 0)){			old = set(place2, orig);
			place2 += 1;
			while (place2 < size()){
			    old = set(place2 , old);
			    place2 += 1;
			}
			add(old);
			place2 = size();
		    }
		    
		    place2 += 1;
		}
	    }
	    place2 = 0;
	    place += 1;
	}
    }
	
    public int find(String target){
	int place = 0;
	int ans = 0;
	while (place < size()){
	    if (target.equals(get(place))){
		ans = place;
		return ans;
	    }
	    place += 1;
	}
	if (place == size() && !get(ans).equals(target)){
	    ans = -1;
	    System.out.println("That element does not exist.");
	}
	return ans;
    }

    public void selectionSort(){
	int place = 0;
	int GoTo = 0;
	int smallestInd = 0;
	String swapped = "";
	while (place < size()){
	    while (GoTo < size()){
		if (get(place).compareTo(get(GoTo)) >= 0){
		    smallestInd = GoTo;
		}
		GoTo += 1;
	    }
	    swapped = set(place, get(smallestInd));
	    set(smallestInd, swapped);
	    place += 1;
	    GoTo = place;
	    System.out.println(this);
	}
    }
		

		 
			    
			   		
		

    //     public static void main(String[]args){
    //     	try{
    //     	    SuperArray test1 = new SuperArray();
    //     	    SuperArray test2 = new SuperArray(2);
    //     	    test1.add("hello");
    //     	    test1.add("meow");
    //     	    test1.add("zzz");
    //     	    test1.add("woof");
    //     	    test1.add("aaa");
    //     	    test1.add("zzz");
    //     	    test1.add("jjj");
    //     	    System.out.println(test1);
    // 	    //    	    test1.insertionSort();
    // 	    test1.selectionSort();
    //     	    System.out.println(test1);
    // 	    // System.out.println(test1.find("zzz")); // expect 5;
    // 	    // System.out.println(test1.find("meow")); // expect 3;
    // 	    // System.out.println(test1.find("ccc")); // this does not exist; expect -1;
	   
	   
    //     	}
    //     	catch(IndexOutOfBoundsException e){
    //     	    System.out.println("hahaha your index is out of bounds.");
    //     	}
    //     }
    // }


    // public static void main(String[]args){
    // 	long startTime = System.currentTimeMillis();
    // 	SuperArray final1 = new SuperArray();
    // 	Random rand = new Random();
    // 	String tester = "aaa";

    // 	int count = 0;
    // 	while (count < 1000){
    // 	    tester = Character.toString((char)('a' + rand.nextInt(25))) + "aa";
    // 	    final1.add(tester);
    // 	    count += 1;
    // 	}

    // 	final1.insertionSort();
    // 	System.out.println(final1);
    // 	long stopTime = System.currentTimeMillis();
    // 	long elapsedTime = stopTime - startTime;
    // 	System.out.println(elapsedTime);

    // }
    // }
}