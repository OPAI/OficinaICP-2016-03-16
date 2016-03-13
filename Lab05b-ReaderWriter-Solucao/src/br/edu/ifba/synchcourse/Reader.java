package br.edu.ifba.synchcourse;

import java.util.concurrent.Semaphore;

public class Reader extends Station{
	
	
	public static int rc = 0;
	
	
	public Reader(int id, DataBase db, Semaphore mutex, Semaphore dbSem){
		super(id, db, mutex, dbSem);
	}	
	
	public void execute() throws InterruptedException, InconsistencyStateException{
		int i = 0;
		while(true){
			this.getMutex().acquire();
			Reader.incRC();
			if(Reader.getRC() == 1)
				this.getDbSem().acquire();
			this.getMutex().release();
			this.getDataBase().read();
			this.getMutex().acquire();
			Reader.decRC();
			if(Reader.getRC() == 0)
				this.getDbSem().release();
			this.getMutex().release();			
			this.useDataRead();
			Thread.yield();
		}	
	}

	private void useDataRead() throws InterruptedException {
		this.wasteTime(100);
	}	
	
	
	public static void incRC(){
		Reader.rc++;
	}
	
	public static void decRC(){
		Reader.rc--;
	}
	
	public static int getRC(){
		return Reader.rc;
	}	
	
}
