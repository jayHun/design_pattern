package state;

interface State{
	public void on_pushed(Light light);
	public void off_pushed(Light light);
}

// ��� ���¿� �̱��� ������ ����
class ON implements State{
	private static ON on = new ON();
	public ON(){}
	public static ON getInstance(){
		return on;
	}
	public void on_pushed(Light light){
		System.out.println("��ħ�� ����");
		light.setState(SLEEPING.getInstance());
	}
	public void off_pushed(Light light){
		System.out.println("Light Off!");
		light.setState(OFF.getInstance());
	}
}

class OFF implements State{
	private static OFF off = new OFF();
	public OFF(){}
	public static OFF getInstance(){
		return off;
	}
	public void on_pushed(Light light){
		System.out.println("Light On!");
		light.setState(ON.getInstance());
	}
	public void off_pushed(Light light){
		System.out.println("��ȭ ����");
	}
}

class SLEEPING implements State{
	private static SLEEPING sleeping = new SLEEPING();
	public SLEEPING(){}
	public static SLEEPING getInstance(){
		return sleeping;
	}
	public void on_pushed(Light light){
		System.out.println("Light On!");
		light.setState(ON.getInstance());
	}
	public void off_pushed(Light light){
		System.out.println("Light Off!");
		light.setState(OFF.getInstance());
	}
}

class Light{
	private State state;
	
	public Light(){
		state = new OFF();	// �ʱ� ���´� OFF
	}
	
	// on ��ư Ŭ��
	public void on_pushed(){
		state.on_pushed(this);
	}
	
	// off ��ư Ŭ��
	public void off_pushed(){
		state.off_pushed(this);
	}
	
	// ���� ����
	public void setState(State state){
		this.state=state;
	}
}


// Client code example
/*
public class state_pattern {
	public static void main(String[] args) {
		Light light = new Light();
		light.off_pushed();
		light.on_pushed();
		light.on_pushed();
		light.on_pushed();
		light.off_pushed();
	}
}
*/