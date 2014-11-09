public class SuperArray{

    Object[]data;
    int currentNumber;

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
	String answer = "";
	while (place < data.length){
	    answer += ("" + data[place]);
	    place += 1;
	}
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

    public void add(Object e){
	if (currentNumber < data.length){
	    data[currentNumber] = e;
	}else{
	    resize(data.length + 1);
	    data[data.length - 1] = e;
	}
	currentNumber += 1;
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

    public void clear(){
	Object[]data2 = new Object[data.length];
	data = data2;
    }

    public Object get(int index){
	if (index < 0 || index > size()){
	    System.out.println("Index is out of range.");
	    return null;
	}else{
	    return "" +  data[index];
	}
    }

    public void set(int index, Object e){
	data[index] = e;
    }




    public static void main(String[]args){
	SuperArray test1 = new SuperArray();
	SuperArray test2 = new SuperArray(2);
	System.out.println(test1.toString());
	System.out.println(test2.toString());
	System.out.println(test1.size());
	test1.resize(15);
	System.out.println(test1.getFullLength());
	Integer x = new Integer(100);
	test2.add(x);
	test2.add(new Integer(101));
	test2.add(102);
	System.out.println(test2.toString());
	test2.resize(20);
	System.out.println(test2.getFullLength());
	System.out.println(test2.size());
	//	test2.clear();
	//	System.out.println(test2.getFullLength());
	//	System.out.println(test2.size());
        test2.set(5, 104);
	System.out.println(test2.toString());
	System.out.println(test2.get(10));
	System.out.println(test2.get(2));
	System.out.println(test2.get(-1));
	System.out.println(test2.size());
	test2.clear();
	System.out.println(test2.toString());
	System.out.println(test2.size());

    }
}
