package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class Consumer extends Station{

	public Consumer(int id, Buffer buffer, Semaphore cheio, Semaphore vazio, Semaphore mutex){
		super(id, buffer, cheio, vazio, mutex);
	}	
	
	public void execute() throws InterruptedException{
		int i = 0;
		while(true){
			try {
				this.getCheio().acquire();
				this.getMutex().acquire();
				System.out.println(this.getId() + " : " + this.getBuffer().get());
				this.getMutex().release();
				this.getVazio().release();
			} catch (DiscardMessageException e) {
				System.out.println("Espaço Vazio - Sem Mensagem Disponível");
				System.exit(0);
			}
			i++;
			this.doAnotherTask();
			
		}
	}	
	
	
}
