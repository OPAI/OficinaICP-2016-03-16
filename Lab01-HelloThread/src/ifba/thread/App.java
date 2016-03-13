package ifba.thread;

public class App {
   public void executar(){
	   Hello hello01 = new Hello(1);
	   Hello hello02 = new Hello(2);
	   Thread hello03 = new Thread(new Hello02(3));
	   Thread hello04 = new Thread(new Hello02(4));
	   
	   hello01.start();
	   hello02.start();
	   hello03.start();
	   hello04.start();
	   
   }
   
   public static void main(String[] args) {
	  App app = new App();
	  app.executar();
   }
}
