package ifba.thread;

public class Hello02 implements Runnable{
	
	private int id;
	
	public Hello02(int id){
		this.id = id;
	}
	
	public void run(){
		while(true){
			System.out.println("Hello World. - Thread" + this.id);
		}
	}

}
