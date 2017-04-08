import java.awt.*;
import java.awt.event.*;
class WindowSensor extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.out.println("Window closing");
	System.exit(0);
	}
}
class ButtonSensor implements ActionListener{
	static int c=0;
	public void actionPerformed(ActionEvent ae){
		System.out.println("Clicked");
		c++;
		System.out.println(c);

	}
}
class MouseSensor extends MouseAdapter{
	public void mousePressed(MouseEvent me){
		System.out.println("Pressed: "+"X:"+me.getX()+"  Y:"+me.getY());
	}
	public void mouseMoved(MouseEvent me){
		System.out.println(me.getX());}
	public void mouseDragged(MouseEvent me){
		System.out.println("Mouse Dragged: "+me.getX()+","+me.getY());
	}

}
class MyFrame extends Frame
{	Button b = new Button("Test");
	
	MyFrame(){
		super("My First Attempt!!");
		setSize(500,300);
		setLocation(300,200);
		add(b);
		this.addMouseListener(new MouseSensor());
		this.addMouseMotionListener(new MouseSensor());
		setLayout(new FlowLayout());
		b.addActionListener(new ButtonSensor());
		
	}
	
}
class Main
{
	public static void main(String arg[])
	{
		MyFrame mf = new MyFrame();
		mf.addWindowListener(new WindowSensor());
                mf.setVisible(true);
		
	}
}