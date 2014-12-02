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
	currentNumber = sizee - 1;
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
    public void add(String e){
	if (currentNumber < data.length){
	    data[currentNumber] = e;
	    currentNumber += 1;
	}else{
	    resize(data.length * 2);
	    data[currentNumber] = e;
	    currentNumber += 1;
	}
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
    public String set(int index, String e){
	String old;
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    old = data[index];
	    data[index] = e;
	    return old;
	}
    }
    public void add(int index, String o){
	int place = 0;
	if (index >= data.length){
	    resize((index + 1) * 2);
	    data[index] = o;
	    leftJustify();
	}else{
	    place = 0;
	    String[]data2 = new String[data.length];
	    while (place < index){
		data2[place] = data[place];
		place += 1;
	    }
	    if (place == index){
		data2[index] = o;
		index += 1;
	    }
	    while (place < size()){
		data2[index] = data[place];
		place += 1;
		index += 1;
	    }
	    data = data2;
	    leftJustify();
	}
	currentNumber += 1;
    }
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
    public static void main(String[]args){
	try{
	    SuperArray test1 = new OrderedSuperArray();
	    SuperArray test2 = new OrderedSuperArray(2);
	    test1.add("hello");
	    System.out.println(test2);
	   
	   
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("hahaha your index is out of bounds.");
	}
    }
}
