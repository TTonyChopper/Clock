import java.lang.Thread;


public class Delay extends Thread
{
	public Delay()
	{     
	}
	public void waitms(long ms)
	{
		try
		{
			//this.start();
			Thread.sleep(ms);
			this.join();
		}
		catch (Exception e)
		{
			System.out.println("Oups "+ e);
		}
	}
}