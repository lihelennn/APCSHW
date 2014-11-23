public class ReadFile{

    public static void scan(String file){

	Scanner sc = new Scanner(new File(file)).useDelimiter("\\s");
	while(sc.hasNext()){
	    System.out.println(sc.next());
	}
    }


    public static void main (String[]args){
	scan("words.txt");
    }

}
