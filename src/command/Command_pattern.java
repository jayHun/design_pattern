package command;

// Lamp 클래스
class Lamp{
	public void turnOn(){
		System.out.println("Lamp On");
	}
	public void turnOff(){
		System.out.println("Lamp Off");
	}
}

// Alarm 클래스
class Alarm{
	public void start(){
		System.out.println("Alarming");
	}
}

// Lamp를 On시키는 커맨드 클래스
class LampOnCommand implements Command{
	private Lamp lamp;
	
	public LampOnCommand(Lamp lamp){
		this.lamp=lamp;
	}
	
	public void execute(){
		lamp.turnOn();
	}
}

// Lamp를 Off시키는 커맨드 클래스
class LampOffCommand implements Command{
	private Lamp lamp;
	
	public LampOffCommand(Lamp lamp){
		this.lamp=lamp;
	}
	
	public void execute(){
		lamp.turnOff();
	}
}

// Alarm을 start시키는 커맨드 클래스
class AlarmCommand implements Command{
	private Alarm alarm;
	
	public AlarmCommand(Alarm alarm){
		this.alarm=alarm;
	}
	
	public void execute(){
		alarm.start();
	}
}

// Command 인터페이스 정의
interface Command{
	public abstract void execute();
}

// 버튼 클래스
class Button{
	private Command theCommand;
	
	public Button(Command theCommand){
		setCommand(theCommand);
	}
	
	public void setCommand(Command command){
		this.theCommand=command;
	}
	
	// 현재 설정된 커맨드를 실행
	public void pressed(){
		theCommand.execute();
	}
}


public class Command_pattern {
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		Command lampon = new LampOnCommand(lamp);
		Button btn1 = new Button(lampon);	// 램프를 켜는 커맨드를 버튼1에 설정
		btn1.pressed();		// 버튼1이 눌리면 램프 켜는 기능이 실행
		
		Command lampoff = new LampOffCommand(lamp);
		btn1.setCommand(lampoff);		// 램프를 끄는 커맨드를 버튼1에 설정
		btn1.pressed();		// 버튼1이 눌리면 램프가 꺼지는 기능이 실행
		
		Alarm alarm = new Alarm();
		Command alarmon = new AlarmCommand(alarm);
		Button btn2 = new Button(alarmon);		// 알람을 울리는 커맨드를 버튼2에 설정
		btn2.pressed();		// 버튼2가 눌리면 알람이 울리는 기능이 실행
	}
}
