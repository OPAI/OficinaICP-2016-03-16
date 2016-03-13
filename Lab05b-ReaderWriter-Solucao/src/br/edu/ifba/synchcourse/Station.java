package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public abstract class Station {
	
	
	private int id;
	private DataBase db;
	private Semaphore mutex;
	private Semaphore dbSem;	
	
	
	public Station(int id, DataBase db, Semaphore mutex, Semaphore dbSem){
		this.setId(id);
		this.setDataBase(db);
		this.setMutex(mutex);
		this.setDbSem(dbSem);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private void setDataBase(DataBase db) {
		this.db = db;
	}
	
	protected DataBase getDataBase() {
		return this.db;
	}	
	
	protected Semaphore getMutex() {
		return mutex;
	}

	protected void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}

	protected Semaphore getDbSem() {
		return dbSem;
	}

	protected void setDbSem(Semaphore dbSem) {
		this.dbSem = dbSem;
	}	
	
	protected void wasteTime(int mult) throws InterruptedException {
		Thread.sleep((long)(Math.random() * mult));		
	}
	
	public abstract void execute() throws Exception;
	
	
	

}
