package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class App {
	
	private static final int TOTAL_CONSUMER = 50;
	private static final int TOTAL_PRODUCER = 20;
	private static final int TOTAL_STATION = App.TOTAL_CONSUMER + App.TOTAL_PRODUCER;

	private static final int TAMANHO_BUFFER = 5;	
	
	
	public void run(){
		Semaphore mutex = new Semaphore(1);
		Semaphore cheio = new Semaphore(0);
		Semaphore vazio = new Semaphore(App.TAMANHO_BUFFER);
		Buffer buffer = new Buffer(App.TAMANHO_BUFFER);
		
		System.out.println("Iniciando....");

		
		
		
		
		Thread[] thread = new Thread[App.TOTAL_STATION];
		
		for(int i = 0; i < App.TOTAL_CONSUMER; i++)
			thread[i] = new Thread(new StationThread(new Consumer(i, buffer, cheio, vazio, mutex)));

		for(int i = TOTAL_CONSUMER, j = 0; i < App.TOTAL_STATION; i++, j++)
			thread[i] = new Thread(new StationThread(new Producer(1000 + j, buffer, cheio, vazio, mutex)));
		
		
		for(int i = 0; i < App.TOTAL_STATION; i++)
			thread[i].start();
		
		
	}
	
	public static void main(String[] args) {
		(new App()).run();
	}

}
