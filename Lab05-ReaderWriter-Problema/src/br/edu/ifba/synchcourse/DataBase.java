package br.edu.ifba.synchcourse;

public class DataBase {
	
	private int reading;
	private int writing;
	
	public DataBase(){
		this.reading = 0;
		this.writing = 0;
	};    
	
    public void read() throws InconsistencyStateException{
    	this.incRead();
    	System.out.println("Atualmente temos " + this.reading + " leitores e " + this.writing + " escritores no banco de dados");
    	this.assertInconsistency();    	
    	this.decRead();
    }
    
    public synchronized void incRead(){
    	this.reading = this.reading + 1;	
    }
    
    public synchronized void decRead(){
    	this.reading = this.reading - 1;	
    }
    
    public synchronized void incWrite(){
    	this.writing = this.writing + 1;	
    }
    
    public synchronized void decWrite(){
    	this.writing = this.writing - 1;	
    }
    
    
    public void write() throws InconsistencyStateException{
    	this.incWrite();
    	System.out.println("Atualmente temos " + this.reading + " leitores e " + this.writing + " escritores no banco de dados");
    	this.assertInconsistency();
    	this.decWrite();	
    }
    
    public void assertInconsistency() throws InconsistencyStateException{
    	if((this.reading > 0 && this.writing > 0) || (this.writing > 1))
    		throw new InconsistencyStateException("Não é possível garantir o estado de consistência: " + this.reading + " leitores e " + this.writing + " escritores no banco");
    }
    
    

}
