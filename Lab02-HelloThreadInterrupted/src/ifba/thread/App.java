package ifba.thread;

public class App {
   public void executar() throws InterruptedException{
	   Hello hello01 = new Hello(1);
	   hello01.start();
	   Thread.sleep(5000);
	   hello01.interrupt();
	   System.out.println("Acabou a bagunça...");
   }
   
   public static void main(String[] args) throws InterruptedException {
	  App app = new App();
	  app.executar();
   }
}
