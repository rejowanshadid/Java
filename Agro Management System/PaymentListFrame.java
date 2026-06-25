//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
//import entities.*;
//import repositories.*;
 
public class PaymentListFrame extends JFrame implements ActionListener
{

    private JButton backBtn;
    private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private OwnerInfo u;
	

    public PaymentListFrame (OwnerInfo u)
    {
        super ("Payment List Frame");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);

    
 







    } 
    public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(backBtn.getText())) 
		
		{
           System.exit(0);
		}
	 /*{
			
			EmployeeFrame emf=new EmployeeFrame(this.u);
			this.setVisible(false);
			emf.setVisible(true);
		}*/
    }
    






}