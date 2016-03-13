package br.edu.ifba.synchcourse;

public abstract class Station {
	
	private int id;
	private DataBase db;
	
	
	public Station(int id, DataBase db){
		this.setId(id);
		this.setDataBase(db);
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
	
	
	public abstract void execute() throws Exception;
	
	
	

}
