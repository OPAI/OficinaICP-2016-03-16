package br.edu.ifba.synchcourse;

public class DataBase {
	
	private int reading = 0;
	private int writing = 0;
	
	public DataBase(){
	};    
	
    public void read() throws InconsistencyStateException, InterruptedException{
    	this.incRead();
    	Thread.yield();
		Thread.sleep((long)(Math.random() * 10));		
    	System.out.println("Atualmente temos " + this.reading + " leitores e " + this.writing + " escritores no banco de dados");
    	this.assertInconsistency();    	
    	this.decRead();
    }
    
    public void incRead(){
    	this.reading = this.reading + 1;	
    }
    
    public void decRead(){
    	this.reading = this.reading - 1;	
    }
    
    public void incWrite(){
    	this.writing = this.writing + 1;	
    }
    
    public void decWrite(){
    	this.writing = this.writing - 1;	
    }
    
    
    public void write() throws InconsistencyStateException, InterruptedException{
    	this.incWrite();
		Thread.sleep((long)(Math.random() * 1000));		
    	System.out.println("Atualmente temos " + this.reading + " leitores e " + this.writing + " escritores no banco de dados");
    	this.assertInconsistency();
    	this.decWrite();	
    }
    
    public void assertInconsistency() throws InconsistencyStateException{
    	if((this.reading > 0 && this.writing > 0) || (this.writing > 1))
    		throw new InconsistencyStateException("Não é possível garantir o estado de consistência: " + this.reading + " leitores e " + this.writing + " escritores no banco");
    }
    
    

}
