package ifba.threads;

import java.util.Random;

public class ContadorThread implements Runnable{
	
	private Contador contador;
	private boolean inc;
	
	public ContadorThread(Contador contador, boolean inc){
		this.contador = contador;
		this.inc = inc;
	}

	@Override
	public void run() {
			for(int i = 0; i < 500; i++){
				if(inc){
					this.contador.inc();
				    System.out.println("Incrementando...");	
				}else{
					this.contador.dec();
					System.out.println("Decrementando...");
				}	
				Thread.yield();
			}
	}
}	
