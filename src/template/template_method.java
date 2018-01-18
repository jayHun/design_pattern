package template;

abstract class Sandwich{
	// template method
	public void makeSand(){
		System.out.println("-- ������ġ ����� --");
		System.out.print("1. �Ʒ��� �� ���" + "\n2. ");
		setPatty();		// primitive(hook) method
		System.out.print("3. �⺻ �����̽� ġ�� ���" + "\n4. ");
		setSauce();		// primitive(hook) method
		System.out.println("5. ���� �� ����");
	}
	// primitive(hook) method
	protected void setPatty(){}
	protected void setSauce(){}
}

// ��ġ ������ġ
class TunaSand extends Sandwich{
	protected void setPatty(){
		System.out.println("��ġ");
	}
	
	protected void setSauce(){
		System.out.println("�������� �ҽ�");
	}
}

// �Ұ�� ������ġ
class BulgogiSand extends Sandwich{
	protected void setPatty(){
		System.out.println("�Ұ��");
	}
	
	protected void setSauce(){
		System.out.println("�����߳� �ҽ�");
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
