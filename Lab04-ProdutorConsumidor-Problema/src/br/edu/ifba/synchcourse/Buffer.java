package br.edu.ifba.synchcourse;

import java.util.ArrayList;
import java.util.List;



public class Buffer {
	

	private List<String> fila;
	private int size;
	
	
	
	public Buffer(int size){
		this.fila = new ArrayList<String>();
		this.size = size;
	}
	
	
	public synchronized void put(String item) throws DiscardMessageException{
		if(this.fila.size() >= this.size)
			throw new DiscardMessageException(item);
		this.fila.add(item);
	}
	
	public synchronized String get(){
		return this.fila.remove(0);
	}
	
	public String bufferStatus(){
		return "Total Mensagens: " + this.fila.size();
	}
	

}
