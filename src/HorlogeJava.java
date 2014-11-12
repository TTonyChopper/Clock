import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HorlogeJava extends JFrame implements 
WindowListener,//Pour evenements fenetre
MethodInterface
{ 
	private JLabel Texte;
	private Alarm alarm;
	private String s;
	private String m;
	private String h;
	private String time;
	private GregorianCalendar calendar; 
	private GridBagConstraints C;
	private GridBagLayout grid;

	public HorlogeJava()
	{	     
		super("H");
		addWindowListener(this);

		setMinimumSize(new Dimension(100,50));
		setLocationRelativeTo(null);

		grid = new GridBagLayout();
		setLayout (grid);
		C= new GridBagConstraints();

		//Placement      
		C.fill = GridBagConstraints.BOTH;


		time = new String("  "+h+": "+m+": "+s+"  ");
		Texte = new JLabel(time);
		method();	
		grid.setConstraints(Texte,C);
		add(Texte); 

		//Afficher
		pack();
		setVisible(true);

		alarm = new Alarm(this, 1000, true); 	      

	} 

	@Override
	public void method()
	{
		calendar = new GregorianCalendar();
		s = String.valueOf(calendar.get(Calendar.SECOND));
		if (s.length()==1) s = "0"+s;
		m = String.valueOf(calendar.get(Calendar.MINUTE));
		if (m.length()==1) m = "0"+m;
		h = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		if (h.length()==1) h = "0"+h;
		time = new String("  "+h+": "+m+": "+s+"  ");
		Texte.setText(time);
	}

	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) 
	{
		System.out.println("Closing...");
		alarm.cancel();
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}