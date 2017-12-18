package strategy;

// Robot 추상 클래스
abstract class Robot {
	private String name;
	private MovingStrategy movingStrategy;
	private AttackStrategy attackStrategy;
	
	public Robot(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void move(){
		movingStrategy.move();
	}
	
	public void attack(){
		attackStrategy.attack();
	}
	
	public void setMovingStrategy(MovingStrategy movingStrategy){
		this.movingStrategy=movingStrategy;
	}
	
	public void setAttackStrategy(AttackStrategy attackStrategy){
		this.attackStrategy=attackStrategy;
	}
}

// Robot의 하위클래스 TaekwonV
class TaekwonV extends Robot{
	public TaekwonV(String name){
		super(name);
	}
}

// Robot의 하위 클래스 Atom
class Atom extends Robot{
	public Atom(String name){
		super(name);
	}
}


interface MovingStrategy{
	public void move();
}

class FlyingStrategy implements MovingStrategy{
	public void move(){
		System.out.println("날아가기");
	}
}

class WalkingStrategy implements MovingStrategy{
	public void move(){
		System.out.println("걷기");
	}
}

interface AttackStrategy{
	public void attack();
}

class MissileStrategy implements AttackStrategy{
	public void attack(){
		System.out.println("미사일로 공격");
	}
}

class PunchStrategy implements AttackStrategy{
	public void attack(){
		System.out.println("펀치로 공격");
	}
}

class Client{
	public static void main(String[] args){
		
		// 태권v 와 아톰 객체 생성
		Robot taekwonv = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");
		
		// 태권v 전략 설정
		taekwonv.setMovingStrategy(new WalkingStrategy());
		taekwonv.setAttackStrategy(new MissileStrategy());
		
		// 아톰 전략 설정
		atom.setMovingStrategy(new FlyingStrategy());
		atom.setAttackStrategy(new PunchStrategy());
		
		System.out.println("이 로봇은 " + taekwonv.getName() + "입니다.");
		taekwonv.move();
		taekwonv.attack();
		System.out.println();
		
		System.out.println("이 로봇은 " + atom.getName() + "입니다.");
		atom.move();
		atom.attack();
	}
}
