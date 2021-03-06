public class SuperArray{

    Object[]data;
    int currentNumber;

    public void leftJustify(){
	int place = 0;
	int place2 = 0;
	Object[]obj2 = new Object[data.length];
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
	data = new Object[10];
	System.out.println("Default array created");
    }

    public SuperArray(int length){
	data = new Object[length];
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
	Object[]data2 = new Object[newCapacity];
	int place = 0;
	while (place < data.length){
	    data2[place] = data[place];
	    place += 1;
	}
	data = data2;
    }

    public void add(Object e){
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
	Object[]data2 = new Object[data.length];
	data = data2;
    }

    public Object get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    return "" +  data[index];
	}
    }

    public Object set(int index, Object e){
	Object old = null;
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    old = data[index];
	    data[index] = e;
	    return old;
	}

    }

    public void add(int index, Object o){
	int place = 0;
	if (index >= data.length){
	    resize((index + 1) * 2);
	    data[index] = o;
	    leftJustify();
	}else{
	    // if (size() == data.length){
	    //	resize(data.length * 2);
	    //	}
	    //  while (place < data.length){
		//	if (data[place] == null){
	    //	    place += 1;
	    //	}else{
	    //	    place = data.length;
	    //	    resize(data.length + 1);
	    //	}
	    // }
	    place = 0;
	    Object[]data2 = new Object[data.length];
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
    
    public Object remove (int index){
	int place = 0;
	Object removed = null;
	Object[]data2 = null;
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();	   
	}else{
	    place = 0;
	    if (size() <= data.length / 4){
                data2 = new Object[data.length / 2];
	    }else{
		data2 = new Object[data.length];
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
	    SuperArray test1 = new SuperArray();
	    SuperArray test2 = new SuperArray(2);
	    System.out.println(test1.toString());
	    System.out.println(test2.toString());
	    System.out.println(test1.size());
	    test1.resize(15);
	    System.out.println(test1.getFullLength());
	    Integer x = new Integer(100);
	    test2.add(x);
	    System.out.println(test2.toString());
	    test2.add(new Integer(101));
	    System.out.println(test2.toString());
	    test2.add(102);
	    System.out.println(test2.toString());
	    test2.add(103);
	    System.out.println(test2.toString());
	    test2.resize(20);
	    System.out.println(test2.getFullLength());
	    System.out.println(test2.size());
	    System.out.println(test2.toString());
	    //	test2.clear();
	    //	System.out.println(test2.getFullLength());
	    //	System.out.println(test2.size());
	    System.out.println(test2.set(2, 104));
	    System.out.println(test2.toString());
	    System.out.println(test2.get(2));
	    test2.remove(0);
	    System.out.println(test2.toString());
	    test2.add(0, 100);
	    System.out.println(test2.toString());
	    System.out.println(test2.set(30, 999));
	    System.out.println(test2.set(5, 999));
	    System.out.println(test2.set(-1, 999));
	    System.out.println(test2.toString());
	    System.out.println(test2.get(10));
	    System.out.println(test2.get(2));
	    System.out.println(test2.get(-1));
	    System.out.println(test2.size());
	    test2.add(11, 99);
	    System.out.println(test2.toString());
	    test2.add(21, 999);
	    System.out.println(test2.toString());
	    test2.add(0, 9);
	    System.out.println(test2.toString());
	    System.out.println(test2.remove(-1));
	    System.out.println(test2.remove(0));
	    System.out.println(test2.toString());
	    System.out.println(test2.remove(18));
	    System.out.println(test2.toString());
	    test2.clear();
	    System.out.println(test2.toString());
	    System.out.println(test2.size());
	    System.out.println(test2.getFullLength());
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("hahaha your index is out of bounds.");
	}
    }
}

