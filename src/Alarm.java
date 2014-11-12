
public class Alarm implements Runnable{ 
	public MethodInterface I;
	long t;
	Boolean repeat;
	Delay delay;

	public Alarm(MethodInterface I, int ms, Boolean bool){
		this.I = I;
		t = (long)ms; 
		repeat = bool;  
		delay = new Delay(); 
		Thread thread = new Thread (this); 
		thread.start(); 
	}

	public void cancel(){
		repeat= false;
	}  

	@Override
	public void run() {
		do 
		{
			I.method();
			delay.waitms(t); 
		}while(repeat);	
	}
}