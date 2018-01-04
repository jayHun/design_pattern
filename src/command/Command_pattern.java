package command;

// Lamp Ŭ����
class Lamp{
	public void turnOn(){
		System.out.println("Lamp On");
	}
	public void turnOff(){
		System.out.println("Lamp Off");
	}
}

// Alarm Ŭ����
class Alarm{
	public void start(){
		System.out.println("Alarming");
	}
}

// Lamp�� On��Ű�� Ŀ�ǵ� Ŭ����
class LampOnCommand implements Command{
	private Lamp lamp;
	
	public LampOnCommand(Lamp lamp){
		this.lamp=lamp;
	}
	
	public void execute(){
		lamp.turnOn();
	}
}

// Lamp�� Off��Ű�� Ŀ�ǵ� Ŭ����
class LampOffCommand implements Command{
	private Lamp lamp;
	
	public LampOffCommand(Lamp lamp){
		this.lamp=lamp;
	}
	
	public void execute(){
		lamp.turnOff();
	}
}

// Alarm�� start��Ű�� Ŀ�ǵ� Ŭ����
class AlarmCommand implements Command{
	private Alarm alarm;
	
	public AlarmCommand(Alarm alarm){
		this.alarm=alarm;
	}
	
	public void execute(){
		alarm.start();
	}
}

// Command �������̽� ����
interface Command{
	public abstract void execute();
}

// ��ư Ŭ����
class Button{
	private Command theCommand;
	
	public Button(Command theCommand){
		setCommand(theCommand);
	}
	
	public void setCommand(Command command){
		this.theCommand=command;
	}
	
	// ���� ������ Ŀ�ǵ带 ����
	public void pressed(){
		theCommand.execute();
	}
}


public class Command_pattern {
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		Command lampon = new LampOnCommand(lamp);
		Button btn1 = new Button(lampon);	// ������ �Ѵ� Ŀ�ǵ带 ��ư1�� ����
		btn1.pressed();		// ��ư1�� ������ ���� �Ѵ� ����� ����
		
		Command lampoff = new LampOffCommand(lamp);
		btn1.setCommand(lampoff);		// ������ ���� Ŀ�ǵ带 ��ư1�� ����
		btn1.pressed();		// ��ư1�� ������ ������ ������ ����� ����
		
		Alarm alarm = new Alarm();
		Command alarmon = new AlarmCommand(alarm);
		Button btn2 = new Button(alarmon);		// �˶��� �︮�� Ŀ�ǵ带 ��ư2�� ����
		btn2.pressed();		// ��ư2�� ������ �˶��� �︮�� ����� ����
	}
}
