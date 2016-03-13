package br.edu.ifba.synchcourse;

public class InconsistencyStateException extends Exception{
	
	private Object message;
	
	public InconsistencyStateException(Object message){
		this.message = message;
		
	}

}
