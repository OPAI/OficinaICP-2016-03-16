package ifba.thread;

public class Hello extends Thread{
	
	private int id;
	
	public Hello(int id){
		this.id = id;
	}
	
	public void run(){
		while(true){
			System.out.println("Hello World. - Thread" + this.id);
		}
	}

}
