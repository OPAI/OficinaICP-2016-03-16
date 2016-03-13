package br.edu.ifba.synchcourse;

public class App {
	
	private static final int TOTAL_READER = 10;
	private static final int TOTAL_WRITER = 1;
	private static final int TOTAL_STATION = App.TOTAL_READER + App.TOTAL_WRITER;
	
	
	public void run(){
		
		
		
		DataBase db = new DataBase();
		Thread[] thread = new Thread[App.TOTAL_STATION];
		
		for(int i = 0; i < App.TOTAL_READER; i++)
			thread[i] = new Thread(new StationThread(new Reader(i, db)));

		for(int i = TOTAL_READER, j = 0; i < App.TOTAL_STATION; i++, j++)
			thread[i] = new Thread(new StationThread(new Writer(j, db)));
		
		
		for(int i = 0; i < App.TOTAL_STATION; i++)
			thread[i].start();
		
	}
	
	public static void main(String[] args) {
		(new App()).run();
	}

}
