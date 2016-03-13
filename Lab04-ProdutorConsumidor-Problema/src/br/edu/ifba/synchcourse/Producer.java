package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class Producer extends Station{
	
	public Producer(int id, Buffer buffer, Semaphore mutex){
		super(id, buffer, mutex);
	}	
	
	public void execute(){
		int i = 0;
		while(true){
			try {
				this.mutex.acquire();
				this.getBuffer().put("["+ this.getId()  + "] Mensagem " + i);
				System.out.println(this.getBuffer().bufferStatus());
			} catch (DiscardMessageException e) {
				System.out.println("Espaço Estourado - Mensagem descartada");
			} catch (InterruptedException e){
			}finally{
				this.mutex.release();
			};
			i++;
			Thread.yield();
		}	
	}
	

}
