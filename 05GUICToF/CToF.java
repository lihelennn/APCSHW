import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class CToF extends JFrame implements ActionListener{

    private Container pane;
    private Jbutton b1;
    private JLabel l1;
    private JTextField t1;

    public CToF(){

	this.setTitle("Conversions to Celsius / Fahrenheit");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    



	pane = this.getContentPane();
	pane.setLayout(newFlowLayout());

	b1 = new JButton("Convert!!");
	l1 = new JLabel("Enter the temperature you want to convert");
	t1 = new JTextField(12);
    }


    public static void main(String[] args){
	CToF g = new CToF();
	g.setVisible(true);
    }




}
