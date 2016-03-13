package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class Consumer extends Station{

	public Consumer(int id, Buffer buffer, Semaphore mutex){
		super(id, buffer, mutex);
	}	
	
	public void execute(){
		while(true){
			try {
				this.mutex.acquire();
				System.out.println(this.getBuffer().get() + " // " + this.getBuffer().bufferStatus());
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Espaço Vazio - Sem Mensagem Disponível");
			} catch (InterruptedException e){
			}finally{
				this.mutex.release();
			};
			Thread.yield();
		}
	}	
	
	
}
