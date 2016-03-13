package br.edu.ifba.synchcourse;

public class DiscardMessageException extends Exception{
	
	private Object message;
	
	public DiscardMessageException(Object message){
		this.message = message;
	}
	
	public String getDiscartedMessage(){
		return this.message.toString();
	}

}
