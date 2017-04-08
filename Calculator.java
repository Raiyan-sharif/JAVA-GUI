import java.awt.*;  
import java.awt.event.*;
import java.lang.*;

public class Calculator extends Frame{  
    
    private Frame calcFrame;
    private Panel calcPanel;
    private TextField firstBox, secondBox;
    private Label result;
    private BasicCalculatorInterface bCal;
    
    Calculator(){
        super("Basic Calculator");
        
        bCal = new BasicCalc();
        
        calcFrame = this;
        
        setSize(390,380);
        
        WindowAdapter closeWindow = new windowCloser();
        calcFrame.addWindowListener(closeWindow);
        buildCalcGui();

        
        setVisible(true);
    }  
    
    private FlowLayout niceFlow(){
        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
        fl.setHgap(15);
        fl.setVgap(22);
        return fl;
    }
    
    private void buildCalcGui(){
    
        calcPanel = new Panel();
        calcPanel.setBackground(Color.RED);
        calcPanel.setLayout(niceFlow());
    
        Label title = new Label(" Basic Calculator ");
        
        
        firstBox = new TextField(40);
        secondBox = new TextField(40);
        
        
        FocusCleaner onFocusClear = new FocusCleaner();
        firstBox.addMouseListener(onFocusClear);
        secondBox.addMouseListener(onFocusClear);
        
        Button add = new Button("  +  ");
        Button sub = new Button("  -  ");
        Button mul = new Button("  *  ");
        Button div = new Button("  /  ");
        
        CalcButtonListener CBL = new CalcButtonListener();
        add.addActionListener(CBL);
        sub.addActionListener(CBL);
        mul.addActionListener(CBL);
        div.addActionListener(CBL);
        
        result = new Label(" ___ ");
        
        calcPanel.add(title);
        calcPanel.add(firstBox);
        calcPanel.add(secondBox);
        calcPanel.add(add);
        calcPanel.add(sub);
        calcPanel.add(mul);
        calcPanel.add(div);
        calcPanel.add(result);
        
        calcFrame.add(calcPanel);
    }
    
    private class FocusCleaner implements MouseListener{

        public void mouseClicked(MouseEvent e) {
        
            TextField tf = (TextField) e.getComponent();
            
            if( (tf.getText()).startsWith("Enter the") ){
                tf.setText("");
            }

        }

      
        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

    }
    
    
    private class CalcButtonListener implements ActionListener{
     

        private boolean isDouble(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public void actionPerformed(ActionEvent e) {
        
            if( isDouble( firstBox.getText() ) && isDouble( secondBox.getText() ) ){
                double firstVal  = Double.parseDouble(firstBox.getText());
                double secondVal = Double.parseDouble(secondBox.getText());
                String command = e.getActionCommand();  
                
                if( command.equals( "  +  " ) ){
                    result.setText(String.valueOf( bCal.sum(firstVal,secondVal) ));
                }
                else if( command.equals( "  -  " ) ){  
                    result.setText(String.valueOf( bCal.sub(firstVal,secondVal) ));
                }
                else if( command.equals( "  *  " ) ){  
                    result.setText(String.valueOf( bCal.mul(firstVal,secondVal) ));
                }
                else if( command.equals( "  /  " ) ){  
                    result.setText(String.valueOf( bCal.div(firstVal,secondVal) ));
                }	
                
            }
            else  {
                    result.setText("Invalid input.");
                }  
            
            
        }		
    }
    
    public static void main(String args[]){ 
        Calculator calc = new Calculator();
    }
}

class windowCloser extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
}


 
interface BasicCalculatorInterface{
	public double sum(double x, double y);
	public double sub(double x, double y);
	public double mul(double x, double y); 
	public double div(double x, double y); 

	public static void main(String args[]){
		BasicCalculatorInterface b = new BasicCalc();
		
		System.out.println(b.sum(1,5));
		
		
		ScientificCalculatorInterface s = new ScientificCalc();
		
		System.out.println(s.XtoY(1,5));
	}
}

class BasicCalc implements BasicCalculatorInterface{
	public double sum(double x, double y){
		return x+y;
	}
	
	public double sub(double x, double y){
		return x-y;
	}
	
	public double mul(double x, double y){
		return x*y;
	}
	
	public double div(double x, double y){
		if(y!=0){
			return x/y;
		}
		else return 0;
	}
}

interface ScientificCalculatorInterface{
        double XtoY(double x, double y);
}

class ScientificCalc extends BasicCalc implements ScientificCalculatorInterface{
	public double XtoY(double x, double y){
		double sum = 0;
		
		if(x<y){
			return 0;
		}
		
		for(double i = x; x <= y; x++){
			sum = sum + i;
		}
		
		return sum;
	}
	
}
