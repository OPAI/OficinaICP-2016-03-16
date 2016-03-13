package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class App {
	
	private static final int TOTAL_CONSUMER = 10;
	private static final int TOTAL_PRODUCER = 1;
	private static final int TOTAL_STATION = App.TOTAL_CONSUMER + App.TOTAL_PRODUCER;
	
	private Semaphore mutex;
	
	
	public void run(){
		this.mutex = new Semaphore(1);
		Buffer buffer = new Buffer(2);
		Thread[] thread = new Thread[App.TOTAL_STATION];
		
		for(int i = 0; i < App.TOTAL_CONSUMER; i++)
			thread[i] = new Thread(new StationThread(new Consumer(i, buffer, mutex)));

		for(int i = TOTAL_CONSUMER, j = 0; i < App.TOTAL_STATION; i++, j++)
			thread[i] = new Thread(new StationThread(new Producer(j, buffer, mutex)));
		
		
		for(int i = 0; i < App.TOTAL_STATION; i++)
			thread[i].start();
		
	}
	
	public static void main(String[] args) {
		(new App()).run();
	}

}
