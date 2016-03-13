package ifba.threads;

import java.util.concurrent.Semaphore;

public class App {
	
	private Semaphore mutex = new Semaphore(1);
	
	
	public void executar() throws InterruptedException{
		Contador contador = new Contador(0);
		Thread t1 = new Thread(new ContadorThread(contador, true, mutex));
		Thread t2 = new Thread(new ContadorThread(contador, false, mutex));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Contador :" + contador.getValor());
	}
	
	public static void main(String[] args) throws InterruptedException {
		(new App()).executar();
	}

}
