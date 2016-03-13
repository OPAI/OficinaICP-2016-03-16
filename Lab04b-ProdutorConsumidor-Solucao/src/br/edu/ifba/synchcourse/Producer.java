package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class Producer extends Station{
	
	public Producer(int id, Buffer buffer, Semaphore cheio, Semaphore vazio, Semaphore mutex){
		super(id, buffer, cheio, vazio, mutex);
	}	
	
	public void execute() throws InterruptedException{
		int i = 0;
		while(true){
			try {
				this.getVazio().acquire();
				this.getMutex().acquire();
				this.getBuffer().put("["+ this.getId()  + "] Mensagem " + i);
				this.getMutex().release();
				this.getCheio().release();
			} catch (DiscardMessageException e) {
				System.out.println("Espaço Estourado - Mensagem descartada: " + e.getDiscartedMessage());
				System.exit(0);
			}			
			i++;
			this.doAnotherTask();
		}	
	}
	

}
