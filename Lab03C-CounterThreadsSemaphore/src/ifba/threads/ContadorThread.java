package ifba.threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ContadorThread implements Runnable{
	
	private Contador contador;
	private boolean inc;
	private Semaphore mutex;
	
	public ContadorThread(Contador contador, boolean inc, Semaphore mutex){
		this.contador = contador;
		this.inc = inc;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		try{
			for(int i = 0; i < 500; i++){
				if(inc){
					this.mutex.acquire(); //down
					this.contador.inc();
					this.mutex.release(); //up
				    System.out.println("Incrementando...");	
				}else{
					this.mutex.acquire(); //down
					this.contador.dec();
					this.mutex.release(); //up
					System.out.println("Decrementando...");
				}	
				Thread.yield();
			}
		} catch (InterruptedException e) {
			
		}
	}
}	
