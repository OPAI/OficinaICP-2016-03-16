package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public abstract class Station {
	
	private int id;
	private Buffer buffer;
	protected Semaphore mutex;
	
	
	public Station(int id, Buffer buffer, Semaphore mutex){
		this.setId(id);
		this.setBuffer(buffer);
		this.mutex = mutex;
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
	
	
	public abstract void execute();
	
	
	

}
