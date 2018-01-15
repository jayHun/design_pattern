package observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// �߻�ȭ�� ���� ���� ���  ������ Ŭ����
abstract class Subject{
	private List<Observer> observers = new ArrayList<Observer>();	// �뺸 ��� ���
	
	public void attach(Observer obs){	// �뺸 ��� �߰�
		observers.add(obs);
	}
	
	public void detach(Observer obs){	// �뺸 ��� ����
		observers.remove(obs);
	}
	
	// ����� �뺸 ���鿡�� ������ �뺸�ϴ� �޼���
	public void notifyObservers(){
		for(Observer o : observers){
			o.update();
		}
	}
}

class ScoreRecord extends Subject{
	private List<Integer> scores = new ArrayList<Integer>();	// ���� ����
	
	// ���� �߰� �޼���
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

//��� ���·� ������ ��� �ϴ� DataSheetView Ŭ����
class DataSheetView implements Observer{
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount){
		this.scoreRecord=scoreRecord;
		this.viewCount=viewCount;
	}
	
	// ������ ������ �뺸�޾Ƽ� �����ϴ� �޼���
	public void update(){
		List<Integer> record = scoreRecord.getScoreRecord();	// ���� ���� ��ȸ
		displayScores(record, viewCount);	// ��ȸ�� ������ viewCount ��ŭ�� ���
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
		
		scoreRecord.attach(datasheet3);		// �ɼ��� �߰�
		scoreRecord.attach(minmax);
		
		for(int index = 1; index<=5; index++){
			int score = index*10;
			System.out.println("Adding " + score);
			scoreRecord.addScore(score);
		}
	}
}
