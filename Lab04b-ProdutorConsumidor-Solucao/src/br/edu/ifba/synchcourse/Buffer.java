package br.edu.ifba.synchcourse;

import java.util.ArrayList;
import java.util.List;



public class Buffer {
	

	private String[] fila;
	private int usado;
	
	
	
	public Buffer(int size){
		this.fila = new String[size];
		this.usado = 0;
	}
	
	
	public void put(String item) throws DiscardMessageException{
		if(this.usado >= this.fila.length)
			throw new DiscardMessageException(item);
		this.fila[this.usado] = item;
		this.usado++;
	}
	
	public String get() throws DiscardMessageException{
		if(usado <= 0)
			throw new DiscardMessageException("EMPTY");
		String item = this.fila[0];
		for(int i = 0; i < this.usado - 1; i++)
			this.fila[i] = this.fila[i+1];
		this.usado--;
		return item;
	}
	
	public String bufferStatus(){
		return "Total Mensagens: " + this.usado;
	}
	
	public String toString(){
	  String rep = "|";
	  int i;
	  for(i = 0; i < this.usado; i++)
		  rep+= " X |";
	  for(; i < this.fila.length; i++)
		  rep+= "   |";
	  
      return rep + " -- Size: " + this.usado;	  
	}
	

}
