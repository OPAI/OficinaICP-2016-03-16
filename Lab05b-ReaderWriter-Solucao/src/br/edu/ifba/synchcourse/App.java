package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class App {
	
	private static final int TOTAL_READER = 10;
	private static final int TOTAL_WRITER = 1;
	private static final int TOTAL_STATION = App.TOTAL_READER + App.TOTAL_WRITER;
	
	
	private Semaphore mutex;
	private Semaphore dbSem;
	
	public App(){
		this.mutex = new Semaphore(1);
		this.dbSem = new Semaphore(1);
	}
	
	
	public void run(){
		DataBase db = new DataBase();
		Thread[] thread = new Thread[App.TOTAL_STATION];
		
		for(int i = 0; i < App.TOTAL_READER; i++)
			thread[i] = new Thread(new StationThread(new Reader(i, db, mutex, dbSem)));

		for(int i = TOTAL_READER, j = 0; i < App.TOTAL_STATION; i++, j++)
			thread[i] = new Thread(new StationThread(new Writer(j, db, mutex, dbSem)));
		
		
		for(int i = 0; i < App.TOTAL_STATION; i++)
			thread[i].start();
		
	}
	
	public static void main(String[] args) {
		(new App()).run();
	}

}
