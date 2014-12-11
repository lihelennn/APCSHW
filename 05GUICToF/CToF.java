import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class CToF extends JFrame implements ActionListener{

    private Container pane;
    private JButton b1;
    private JLabel l1;
    private JTextField t1;
    private JTextField answer;
    private JButton CToF;
    private JButton FToC;
    private JLabel answerDisplay;

    public CToF(){

	this.setTitle("Conversions to Celsius / Fahrenheit");
	this.setSize(800,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	l1 = new JLabel("Enter the temperature you want to convert");
	t1 = new JTextField(8);
	answer = new JTextField(12);
	CToF = new JButton("Convert me to Fahrenheit!");
	FToC = new JButton("Convert me to Celsius!");
	answerDisplay = new JLabel("Here is what your wants");
    
	CToF.setActionCommand("convertToF");
	CToF.addActionListener(this);
	FToC.setActionCommand("convertToC");
	FToC.addActionListener(this);
	// ButtonGroup group = new ButtonGroup();
	// group.add(CToF);
	// group.add(FToC);
	

	Container ask = new Container();
	ask.setLayout(new FlowLayout());
	ask.add(l1);
	ask.add(t1);
	ask.add(CToF);
	ask.add(FToC);
      

	Container answers = new Container();
	answer.setLayout(new FlowLayout());
	ask.add(answerDisplay);
	ask.add(answer);

	pane.add(ask);
	pane.add(answers);
    }

    public void actionPerformed(ActionEvent e) throws NumberFormatException{
	String action = e.getActionCommand();
	try{
	    String s = t1.getText();
	    Double temperature = Double.parseDouble(s);
	    System.out.println(temperature);
	    if (action.equals("convertToF")){
	        temperature = ((9.0 / 5) * temperature) + 32;
		System.out.println(temperature);
	    }else{
		if (action.equals("convertToC")){
		    temperature = (temperature - 32) * (5.0 / 9);
		}
	    }
	    s = Double.toString(temperature);
	   answer.setText(s);
	}catch(NumberFormatException c){
	    System.out.println("Input a number please!");
	    answer.setText("Input a number please!");
	}
    }


    public static void main(String[] args){
	CToF g = new CToF();
	g.setVisible(true);
    }


}
