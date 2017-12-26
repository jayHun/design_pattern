package decorator;

// Component
abstract class Display{
	// operation
	public abstract void draw();
}

// ConcreteComponent
class RoadDisplay extends Display{
	public void draw(){
		System.out.println("���� ǥ��");
	}
}

// Decorator
abstract class DisplayDecorator extends Display{
	private Display displayDecorator;
	
	public DisplayDecorator(Display displayDecorator){
		this.displayDecorator=displayDecorator;
	}
	
	@Override
	public void draw(){
		displayDecorator.draw();
	}
}

// ���� ǥ�� Decorator
class LaneDecorator extends DisplayDecorator{
	public LaneDecorator(Display displayDecorator){
		super(displayDecorator);
	}
	
	@Override
	public void draw(){
		super.draw();
		drawLane();
	}
	
	private void drawLane(){
		System.out.println("���� ǥ��");
	}
}

// ���뷮 ǥ�� Decorator
class TrafficDecorator extends DisplayDecorator{
	public TrafficDecorator(Display displayDecorator){
		super(displayDecorator);
	}
	
	@Override
	public void draw(){
		// �⺻ ���� ǥ��
		super.draw();
		drawTraffic();
	}
	
	private void drawTraffic(){
		System.out.println("���뷮 ǥ��");
	}
}

// ������ ǥ�� Decorator
class CrossingDecorator extends DisplayDecorator{
	public CrossingDecorator(Display displayDecorator){
		super(displayDecorator);
	}
	
	@Override
	public void draw(){
		super.draw();
		drawCrossing();
	}
	
	private void drawCrossing(){
		System.out.println("������ ǥ��");
	}
}

// ���ڸ� ���� �߰� ����� �������� �����ϴ� �ڵ�
class User{
	public static void main(String[] args){
		Display road = new RoadDisplay();
		for(String decoratorName:args){
			if(decoratorName.equalsIgnoreCase("Lane"))
				road = new LaneDecorator(road);
			if(decoratorName.equalsIgnoreCase("Traffic"))
				road = new TrafficDecorator(road);
			if(decoratorName.equalsIgnoreCase("Crossing"))
				road = new CrossingDecorator(road);
		}
		road.draw();
	}
}


/*
Display roadWithTrafficAndCrossingAndLane = new LaneDecorator(
		new CrossingDecorator(new TrafficDecorator(new RoadDisplay())));
roadWithTrafficAndCrossingAndLane.draw();
*/