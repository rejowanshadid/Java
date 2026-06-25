import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Registration extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	   
	JTextField t1,t2,t3;
	   
	JButton b1,b2;
	   
	JPasswordField pa1,pa2;
	   
	JComboBox c1;

	JCheckBox ch1;
	   
	JPanel P1,P2;

	
	

    public Registration ()
    {
        this.setTitle(" Sign Up Form ");
		this.setSize(750,510);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icon.png"));
		this.setIconImage(image.getImage());



    //creating panel
        P1 = new JPanel();
        P1.setBounds(0,0,750,500);
        P1.setLayout(null);


    //labels

        l1 = new JLabel("Create your free account");
		l1.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,22));
		l1.setForeground(new Color(80, 200, 120));
		l1.setBounds(260,40,500,28);
		P1.add(l1);
	
        l2 = new JLabel("Full Name :");
		l2.setFont(new Font("Georgia",Font.PLAIN,16));
		l2.setForeground(Color.white);
		l2.setBounds(180,90,200,20);
		P1.add(l2);
			
		t1 = new JTextField();
		t1.setFont(new Font("Georgia",Font.PLAIN,17));
		t1.setBounds(338,90,235,25);
		t1.addActionListener(this);
		P1.add(t1);

        l3 = new JLabel("Mobile Number :");
        l3.setFont(new Font("Georgia",Font.PLAIN,16));
        l3.setForeground(Color.white);
        l3.setBounds(180,140,250,25);
        P1.add(l3);
    		
        t2 = new JTextField();
		t2.setFont(new Font("Georgia",Font.PLAIN,16));
        t2.setBounds(338,140,235,25);
		t2.addActionListener(this);
        P1.add(t2);

       l4 = new JLabel("Email :");
	   l4.setFont(new Font("Georgia",Font.PLAIN,16));
	   l4.setForeground(Color.white);
	   l4.setBounds(180,190,250,25);
	   l4.add(l4);
			
	   t3 = new JTextField();
	   t3.setFont(new Font("Georgia",Font.PLAIN,16));
	   t3.setBounds(338,190,235,25);
	   t3.addActionListener(this);
	   P1.add(t3);

       l5 = new JLabel("Gender :");
	   l5.setFont(new Font("Georgia",Font.PLAIN,16));
	   l5.setForeground(Color.white);
	   l5.setBounds(180,240,250,22);
	   P1.add(l5);
			
	   String gender[]={"Male","Female"};
	   c1 = new JComboBox(gender);
	   c1.setFont(new Font("Georgia",Font.PLAIN,16));
	   c1.setBounds(338,240,235,25);
	   P1.add(c1);

       l6 = new JLabel("Password : ");
	   l6.setFont(new Font("Georgia",Font.PLAIN,16));
	   l6.setForeground(Color.white);
	   l6.setBounds(180,290,250,25);
	   P1.add(l6);
			
	   pa1 = new JPasswordField();
	   pa1.setFont(new Font("Georgia",Font.PLAIN,16));
	   pa1.setBounds(338,290,235,25);
	   pa1.setEchoChar('*');
	   pa1.addActionListener(this);
	   P1.add(pa1);

       l7 = new JLabel("Retype Password : ");
       l7.setFont(new Font("Georgia",Font.PLAIN,16));
       l7.setForeground(Color.white);
       l7.setBounds(180,340,250,25);
       P1.add(l7);
    
       pa2 = new JPasswordField();
	   pa2.setFont(new Font("Georgia",Font.PLAIN,16));
       pa2.setBounds(338,340,235,25);
	   pa2.setEchoChar('*');
	   pa2.addActionListener(this);
       P1.add(pa2);

    //button
	   b1 = new JButton("Back");
	   b1.setFont(new Font("Georgia",Font.BOLD,16));
	   b1.setForeground(Color.white);
	   b1.setBackground(new Color(80, 200, 120));
	   b1.setBorder(null);
	   b1.setBounds(183,417,170,25);
	   b1.addActionListener(this);
	   b1.setFocusable(false);
	   b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P1.add(b1);

	   b2 = new JButton("Confirm");
	   b2.setFont(new Font("Georgia",Font.BOLD,16));
	   b2.setForeground(Color.white);
	   b2.setBackground(new Color(80, 200, 120));
	   b2.setBounds(400,417,170,25); 
	   b2.addActionListener(this);
	   b2.setFocusable(false);
	   b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P1.add(b2);

	   ch1 = new JCheckBox("Show password");
	   ch1.setFont(new Font("Georgia",Font.PLAIN,14));
	   ch1.setForeground(Color.black);
	   ch1.setBackground(new Color(240,240,240));
	   ch1.setBounds(338,370,235,25);
	   ch1.addActionListener(this); 
	   ch1.setFocusable(false);
	   ch1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P1.add(ch1);

    //image
	   l8 = new JLabel(new ImageIcon(getClass().getResource("/image/registration.png")));
	   l8.setBounds(0,0,750,500);
	   P1.add(l8);

       this.add(P1);
       setVisible(true);

    }


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			CusLogin cl = new CusLogin();
			this.setVisible(false);
		    cl.setVisible(true);
		}
		else if(ae.getSource()==b2){

			if(t1.getText().length() <=0 || t2.getText().length() <=0 || t3.getText().length() <=0 || pa1.getText().length() <=0 || pa2.getText().length() <=0 ){
				JOptionPane.showMessageDialog(this,"Fill all information");
			}


			else if(!(pa1.getText()).equals(pa2.getText())){
				JOptionPane.showMessageDialog(this," Password doesn't match ");
			}

		// making file for data
			else{
				JOptionPane.showMessageDialog(this," Account created successfully !! ");
   

				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter("data\\cusData.txt", true));
					writer.write("Name        :  "+t1.getText());
					writer.write("\nPassword  :  "+pa1.getText());
					writer.write("\nMobile       :  "+t2.getText());
					writer.write("\nEmail         :  "+t3.getText());
					writer.write("\nGender      :  "+c1.getSelectedItem()+"\n\n=================\n");
					writer.close();
				}
				catch(IOException e){
				    System.out.println("excepton handled");
				}

		// clearing the textfields 
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				pa1.setText(null);
				pa2.setText(null);
			}

		}
	
		else if(ch1.isSelected()){
		 pa1.setEchoChar((char)0);
		 pa2.setEchoChar((char)0);
		}
		else{
		pa1.setEchoChar('*');
		pa2.setEchoChar('*');
	
	    }

	}

	public static void main(String [] args){
		
		Registration r = new Registration();
		
	}

}



