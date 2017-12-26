package decorator;

// Component
abstract class Display{
	// operation
	public abstract void draw();
}

// ConcreteComponent
class RoadDisplay extends Display{
	public void draw(){
		System.out.println("도로 표시");
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

// 차선 표시 Decorator
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
		System.out.println("차선 표시");
	}
}

// 교통량 표시 Decorator
class TrafficDecorator extends DisplayDecorator{
	public TrafficDecorator(Display displayDecorator){
		super(displayDecorator);
	}
	
	@Override
	public void draw(){
		// 기본 도로 표시
		super.draw();
		drawTraffic();
	}
	
	private void drawTraffic(){
		System.out.println("교통량 표시");
	}
}

// 교차로 표시 Decorator
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
		System.out.println("교차로 표시");
	}
}

// 인자를 통해 추가 기능을 동적으로 생성하는 코드
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