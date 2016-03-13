package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class Writer extends Station{
	
	public Writer(int id, DataBase db, Semaphore mutex, Semaphore dbSem){
		super(id, db, mutex, dbSem);
	}	
	
	public void execute() throws InterruptedException, InconsistencyStateException{
		int i = 0;
		while(true){
			this.thinkUpData();
			this.getDbSem().acquire();
			this.getDataBase().write();
			this.getDbSem().release();
			Thread.yield();
		}	
	}

	private void thinkUpData() throws InterruptedException {
		this.wasteTime(1);
	}

	
	

}
