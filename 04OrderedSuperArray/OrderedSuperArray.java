public class OrderedSuperArray extends SuperArray{

    String[]data;

    public void add(String element){
	System.out.println(element);
	if (size() == 0){
	    super.add(element);
	    System.out.println(data + "first element woohoo!");
	}else{
	    int place = 0;
	    String old = "";
	    while (place < this.size()){
		System.out.println(data);
		if (element.compareTo(get(place)) <= 0){
		    System.out.println("yay");
		    super.add(place, element);
		}
		place += 1;
		System.out.println(data);
	    }
	}
    }
  

    public String set(int index, String e){
	String str = remove(index);
	add(e);
	return str;
    }
	
		


    public void add(int index, String element){
	add(element);
    }

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }



    public static void main(String[]args){
	OrderedSuperArray test1 = new OrderedSuperArray();
	test1.add("bbb");
	test1.add("aaa");
	test1.add("mmm");
	test1.add("hhh");
	System.out.println(test1);
    }
	    
}
