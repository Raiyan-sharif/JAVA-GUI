import java.awt.*;
import java.awt.event.*;
class WindowSensor extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.out.println("Window closing");
	System.exit(0);
	}
}

class ButtonSensor implements ActionListener{
	static int c;
	MyFrame fm;
	public ButtonSensor(MyFrame f){
		fm=f;
	}
	public void actionPerformed(ActionEvent ae){
		//System.out.println("Clicked");
		c++;
		fm.setMessage("Button Pressed: "+c);
		fm.repaint();
		System.out.println("Button Pressed :"+c);
		//System.out.println(c);

	}
}

/*class MouseSensor extends MouseAdapter{
	public void mousePressed(MouseEvent me){
		System.out.println("Pressed: "+"X:"+me.getX()+"  Y:"+me.getY());
	}
	public void mouseMoved(MouseEvent me){
		System.out.println(me.getX());}
	public void mouseDragged(MouseEvent me){
		System.out.println("Mouse Dragged: "+me.getX()+","+me.getY());
	}

}*/
class MyFrame extends Frame
{	//Button b = new Button("Test");
	private String msg;
	public MyFrame(){
		//super("My First Attempt!!");
		super("java First Windows");
		Button b = new Button("OK");
		msg = ("Frame is created");
		setSize(1600,1300);
		setLayout(new FlowLayout());
		
		//setLocation(300,200);
		add(b);
		//this.addMouseListener(new MouseSensor());
		//this.addMouseMotionListener(new MouseSensor());
		//setLayout(new FlowLayout());
		b.addActionListener(new ButtonSensor(this));
		
		
	}
	public void setMessage(String s){
		msg =s;
	}
	public void paint(Graphics g){
		//g.drawLine(100,100,200,200);
		//g.setColor(Color.RED);
		g.setColor(Color.GREEN);
		g.fillRect(200, 200, 200, 100);
		g.setColor(Color.BLACK);
		g.drawRect(198,198,201,101);
		g.setColor(Color.RED);
		//g.drawRect(100,120,200,100);
		g.fillOval(275, 220, 50,50);
		//g.drawString(msg,20,40);
		g.setColor(Color.darkGray);
		g.fillRect(190, 198, 10, 300);

		//Pole Upper Thing
		Polygon p= new Polygon();
		int x=190;
		int y = 198;
		p.addPoint(x,y);
		p.addPoint(x+10,y);
		p.addPoint(x+5,y-5);
		g.fillPolygon(p);

		//Text field
		g.setColor(Color.RED);
		Font font1 = new Font("Book Antiqua", Font.PLAIN, 60);
		g.setFont(font1);
		g.drawString("National Flag",150,550);
		
		
		
	}
	
	
}
public class Main
{
	public static void main(String arg[])
	{
		MyFrame mf = new MyFrame();
		mf.addWindowListener(new WindowSensor());
                mf.setVisible(true);
		
	}
}