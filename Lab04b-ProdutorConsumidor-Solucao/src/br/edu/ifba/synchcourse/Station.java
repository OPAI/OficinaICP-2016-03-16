package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public abstract class Station {
	
	
	protected static final int TOTAL_MSG = 50;
	
	private int id;
	private Buffer buffer;


	private Semaphore cheio;
	private Semaphore vazio;
	private Semaphore mutex;
	
	public Station(int id, Buffer buffer, Semaphore cheio, Semaphore vazio, Semaphore mutex){
		this.setId(id);
		this.setBuffer(buffer);
		this.setCheio(cheio);
		this.setVazio(vazio);
		this.setMutex(mutex);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	protected Buffer getBuffer() {
		return this.buffer;
	}	
	
	
	protected Semaphore getCheio() {
		return this.cheio;
	}

	protected void setCheio(Semaphore cheio) {
		this.cheio = cheio;
	}

	protected Semaphore getVazio() {
		return this.vazio;
	}

	protected void setVazio(Semaphore vazio) {
		this.vazio = vazio;
	}
	
	
	protected void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}
	
	protected Semaphore getMutex() {
		return this.mutex;
	}	

	
	
	public abstract void execute() throws InterruptedException;
	
	
	protected String getSemStatus(){
		return 	this.getMutex() + " : " + this.getVazio() + " : " +this.getCheio();
	}
	
	protected void doAnotherTask() throws InterruptedException{
		//Thread.sleep((long)(Math.random() * 100));
		Thread.yield();
	}	

}
