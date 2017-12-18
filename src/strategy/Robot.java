package strategy;

// Robot �߻� Ŭ����
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

// Robot�� ����Ŭ���� TaekwonV
class TaekwonV extends Robot{
	public TaekwonV(String name){
		super(name);
	}
}

// Robot�� ���� Ŭ���� Atom
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
		System.out.println("���ư���");
	}
}

class WalkingStrategy implements MovingStrategy{
	public void move(){
		System.out.println("�ȱ�");
	}
}

interface AttackStrategy{
	public void attack();
}

class MissileStrategy implements AttackStrategy{
	public void attack(){
		System.out.println("�̻��Ϸ� ����");
	}
}

class PunchStrategy implements AttackStrategy{
	public void attack(){
		System.out.println("��ġ�� ����");
	}
}

class Client{
	public static void main(String[] args){
		
		// �±�v �� ���� ��ü ����
		Robot taekwonv = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");
		
		// �±�v ���� ����
		taekwonv.setMovingStrategy(new WalkingStrategy());
		taekwonv.setAttackStrategy(new MissileStrategy());
		
		// ���� ���� ����
		atom.setMovingStrategy(new FlyingStrategy());
		atom.setAttackStrategy(new PunchStrategy());
		
		System.out.println("�� �κ��� " + taekwonv.getName() + "�Դϴ�.");
		taekwonv.move();
		taekwonv.attack();
		System.out.println();
		
		System.out.println("�� �κ��� " + atom.getName() + "�Դϴ�.");
		atom.move();
		atom.attack();
	}
}
