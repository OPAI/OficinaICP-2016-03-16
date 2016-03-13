package ifba.threads;

public class Contador {
	
	private int valor;
	

	public Contador(int valor) {
		super();
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void inc(){
		int atual = this.valor;
		Thread.yield();
		atual = atual + 1;
		Thread.yield();
		this.valor = atual;
		Thread.yield();
	}
	
	public void dec(){
		int atual = this.valor;
		Thread.yield();
		atual = atual - 1;
		Thread.yield();
		this.valor = atual;
		Thread.yield();
	}
	
	
	

}
