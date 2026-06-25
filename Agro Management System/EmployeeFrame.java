
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
//import Entities.*;
//import repositories.*;

public class EmployeeFrame extends JFrame implements ActionListener
{
    private JButton takeOrderButton ,orderListButton,takePaymentButton,paymentListButton,productListButton,orderLineListButton,customerListButton,backButton;
    private JPanel panel;
	private Container c;

    public EmployeeFrame()
    {
        super (" Employee Home Frame");
        this.setSize(800,510);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel =new JPanel();
        this.panel.setLayout(null);
		//c = this.getContentPane();
		panel.setBackground(Color.ORANGE);

		


        this.takeOrderButton=new JButton("Take Order");
		this.takeOrderButton.setBounds(515,285,120,40);
		this.takeOrderButton.addActionListener(this);
		this.panel.add(takeOrderButton);

        this.orderListButton=new JButton("Order List");
		this.orderListButton.setBounds(665,285,120,40);
		this.orderListButton.addActionListener(this);
		this.panel.add(orderListButton);

        this.takePaymentButton=new JButton("Take Payment");
		this.takePaymentButton.setBounds(515,335,120,40);
		this.takePaymentButton.addActionListener(this);
		this.panel.add(takePaymentButton);

        this.paymentListButton=new JButton("Payment List");
		this.paymentListButton.setBounds(665,335,120,40);
		this.paymentListButton.addActionListener(this);
		this.panel.add(paymentListButton);

        this.productListButton=new JButton("Product List");
		this.productListButton.setBounds(665,390,120,40);
		this.productListButton.addActionListener(this);
		this.panel.add(productListButton);



        this.orderLineListButton=new JButton("Order Line  List");
		this.orderLineListButton.setBounds(515,390,120,40);
		this.orderLineListButton.addActionListener(this);
		this.panel.add(orderLineListButton);

        this.customerListButton=new JButton("Customer List");
		this.customerListButton.setBounds(570,230,160,40);
		this.customerListButton.addActionListener(this);
		this.panel.add(customerListButton);

		this.backButton=new JButton("Back");
		this.backButton.setBounds(40,420,100,35);
		this.backButton.addActionListener(this);
		this.panel.add(backButton);



        
        this.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();

        if (command.equals(orderListButton.getText())) {
         OrderTable ot=new OrderTable();
            this.setVisible(false);
            ot.setVisible(true);

        }

		if (command.equals(paymentListButton.getText())) {
			PaymentTable ot=new PaymentTable();
			   this.setVisible(false);
			   ot.setVisible(true);
   
		   }

		   if (command.equals(productListButton.getText())) {
			ProductTable ot=new ProductTable();
			   this.setVisible(false);
			   ot.setVisible(true);
   
		   } 

		   if (command.equals(customerListButton.getText())) {
			CustomerTable ot=new CustomerTable();
			   this.setVisible(false);
			   ot.setVisible(true);
   
		   }  

		   if (command.equals(takeOrderButton.getText())) {
			 
			JOptionPane.showMessageDialog(this, "Order Taking", "Notification", JOptionPane.INFORMATION_MESSAGE);
   
		   }  

		   
		   if (command.equals(takePaymentButton.getText())) {
			 
			JOptionPane.showMessageDialog(this, "Payment Taking", "Notification", JOptionPane.INFORMATION_MESSAGE);
   
		   }  

		   if (command.equals(orderLineListButton.getText())) {
			 
			JOptionPane.showMessageDialog(this, "Order Line List", "Notification", JOptionPane.INFORMATION_MESSAGE);
   
		   }  

        




    }
	

	
 	 public static void main(String[] args) 
	
	{
		EmployeeFrame ef=new EmployeeFrame();
		ef.setVisible(true);
	}
 

    
}

