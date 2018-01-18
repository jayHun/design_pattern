package template;

abstract class Sandwich{
	// template method
	public void makeSand(){
		System.out.println("-- 샌드위치 만들기 --");
		System.out.print("1. 아래의 빵 깔기" + "\n2. ");
		setPatty();		// primitive(hook) method
		System.out.print("3. 기본 슬라이스 치즈 얹기" + "\n4. ");
		setSauce();		// primitive(hook) method
		System.out.println("5. 위의 빵 덮기");
	}
	// primitive(hook) method
	protected void setPatty(){}
	protected void setSauce(){}
}

// 참치 샌드위치
class TunaSand extends Sandwich{
	protected void setPatty(){
		System.out.println("참치");
	}
	
	protected void setSauce(){
		System.out.println("갈릭마요 소스");
	}
}

// 불고기 샌드위치
class BulgogiSand extends Sandwich{
	protected void setPatty(){
		System.out.println("불고기");
	}
	
	protected void setSauce(){
		System.out.println("데리야끼 소스");
	}
}

public class template_method {
	public static void main(String[] args) {
		Sandwich order1 = new TunaSand();
		Sandwich order2 = new BulgogiSand();
		
		order1.makeSand();
		System.out.println("");
		order2.makeSand();
	}
}
