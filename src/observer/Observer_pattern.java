package observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 추상화된 변경 관심 대상  데이터 클래스
abstract class Subject{
	private List<Observer> observers = new ArrayList<Observer>();	// 통보 대상 목록
	
	public void attach(Observer obs){	// 통보 대상 추가
		observers.add(obs);
	}
	
	public void detach(Observer obs){	// 통보 대상 제거
		observers.remove(obs);
	}
	
	// 저장된 통보 대상들에게 변경을 통보하는 메서드
	public void notifyObservers(){
		for(Observer o : observers){
			o.update();
		}
	}
}

class ScoreRecord extends Subject{
	private List<Integer> scores = new ArrayList<Integer>();	// 점수 저장
	
	// 점수 추가 메서드
	public void addScore(int score){
		scores.add(score);
		notifyObservers();
	}
	
	public List<Integer> getScoreRecord(){
		return scores;
	}
}

interface Observer{
	public abstract void update();
}

//목록 형태로 점수를 출력 하는 DataSheetView 클래스
class DataSheetView implements Observer{
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount){
		this.scoreRecord=scoreRecord;
		this.viewCount=viewCount;
	}
	
	// 점수의 변경을 통보받아서 갱신하는 메서드
	public void update(){
		List<Integer> record = scoreRecord.getScoreRecord();	// 점수 변경 조회
		displayScores(record, viewCount);	// 조회된 점수를 viewCount 만큼만 출력
	}
	
	private void displayScores(List<Integer> record, int viewCount){
		System.out.print("List of " +  viewCount + " entries: ");
		for(int i=0; i<viewCount && i<record.size(); i++){
			System.out.print(record.get(i) + " ");
		}
		System.out.println();
	}
}

class MinMaxView implements Observer{
	private ScoreRecord scoreRecord;
	
	public MinMaxView(ScoreRecord scoreRecord){
		this.scoreRecord=scoreRecord;
	}
	
	public void update(){
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record);
	}
	
	public void displayMinMax(List<Integer> record){
		int min = Collections.min(record);
		int max = Collections.max(record);
		System.out.println("Min: " + min + " Max: " + max +
				"\n=============================\n");
	}
}

public class Observer_pattern{
	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		
		Observer datasheet3 = new DataSheetView(scoreRecord, 3);
		Observer minmax = new MinMaxView(scoreRecord);
		
		scoreRecord.attach(datasheet3);		// 옵서버 추가
		scoreRecord.attach(minmax);
		
		for(int index = 1; index<=5; index++){
			int score = index*10;
			System.out.println("Adding " + score);
			scoreRecord.addScore(score);
		}
	}
}
