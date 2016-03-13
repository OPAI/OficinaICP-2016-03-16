package br.edu.ifba.synchcourse;

public class Reader extends Station{

	public Reader(int id, DataBase db){
		super(id, db);
	}	
	
	public void execute() throws InterruptedException, InconsistencyStateException{
		int i = 0;
		while(true){
			this.getDataBase().read();
			this.useDataRead();
			Thread.yield();
		}	
	}

	private void useDataRead() throws InterruptedException {
		Thread.sleep((long)(Math.random() * 10));
	}	
	
	

	
}
