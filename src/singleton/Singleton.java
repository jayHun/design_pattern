package singleton;

// User
class User{
	private String name;
	
	public User(String name){
		this.name=name;
	}
	
	public void print(){
		Printer printer = Printer.getPrinter();
		printer.print(this.name + " print using " + printer.toString() + ".");
	}
}

// 인스턴스를 만드는 메서드에 동기화하는 방법
class Printer{
	private static Printer printer = null;
	private Printer(){}
	
	// getter
	public synchronized static Printer getPrinter(){
		if(printer == null)
			printer = new Printer(); 
		return printer;
	}
	
	// concrete printing method
	public void print(String str){
		System.out.println(str);
	}
}

// main class
public class Singleton {
	private static final int User_NUM = 5;
	public static void main(String[] args) {
		User[] user = new User[User_NUM];
		for(int i=0; i< User_NUM; i++){
			user[i] = new User((i+1) + "-user");
			user[i].print();
		}
	}
}
