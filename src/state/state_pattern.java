package state;

interface State{
	public void on_pushed(Light light);
	public void off_pushed(Light light);
}

// 모든 상태에 싱글톤 패턴을 적용
class ON implements State{
	private static ON on = new ON();
	public ON(){}
	public static ON getInstance(){
		return on;
	}
	public void on_pushed(Light light){
		System.out.println("취침등 상태");
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
		System.out.println("변화 없음");
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
		state = new OFF();	// 초기 상태는 OFF
	}
	
	// on 버튼 클릭
	public void on_pushed(){
		state.on_pushed(this);
	}
	
	// off 버튼 클릭
	public void off_pushed(){
		state.off_pushed(this);
	}
	
	// 상태 저장
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