package br.edu.ifba.synchcourse;

public class Writer extends Station{
	
	public Writer(int id, DataBase db){
		super(id, db);
	}	
	
	public void execute() throws InterruptedException, InconsistencyStateException{
		int i = 0;
		while(true){
			this.thinkUpData();
			this.getDataBase().write();
			Thread.yield();
		}	
	}

	private void thinkUpData() throws InterruptedException {
		Thread.sleep((long)(Math.random() * 10));
	}
	
	

}
