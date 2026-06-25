
import javax.swing.*;  
import java.awt.event.*;  
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Nagad implements ActionListener{  
    
	 JButton lgnBtn;
     JButton sign;
     JButton cancel;
     JLabel lusn;
     JLabel lpass;
     JLabel Inum;
     JTextField uname;
     JTextField upass;
     JTextField unum;
	JFrame frame;
	
 
   public Nagad(){  
	
		
        //create frame
		frame = new JFrame ("Aegro");
        //construct components
		sign = new JButton("Confirm");
				cancel = new JButton("Cancel");

        lusn = new JLabel ("NAGAD Number");
        lpass = new JLabel ("NAGAD PIN");
        Inum = new JLabel ("Name");
        uname = new JTextField ();
        upass = new JTextField ();
        unum = new JTextField ();
		

		

		
		//addActionListener
		sign.addActionListener(this);
		cancel.addActionListener(this);

        //add components
        frame.add (sign);
        frame.add (cancel);
		
        frame.add (lusn);
        frame.add (lpass);
        frame.add (uname);
        frame.add (upass);
        frame.add (Inum);
        frame.add (unum);
		
 ImageIcon img = new ImageIcon("D:\\meher\\Image\\nagad.png");
		 frame.setIconImage(img.getImage());

		JLabel background = new JLabel("",img,JLabel.CENTER);
		
        background.setVerticalAlignment(JLabel.CENTER);
		background.setHorizontalAlignment(JLabel.CENTER);
background.setBackground(Color.white);
background.setOpaque(true);
lusn.setForeground(Color.white);
lpass.setForeground(Color.white);
Inum.setForeground(Color.white);

     Container contentPane = frame.getContentPane();

        // Set the background color of the content pane
        contentPane.setBackground(Color.decode("#FF3C00")); 




		frame.add(background);
		frame.setResizable(false);
		
		//frame properties
		//adjust size and set layout
        frame.setSize (1045, 600);		//set component bounds (only needed by Absolute Positioning)
       sign.setBounds (400, 450, 100, 30);
        cancel.setBounds (550, 450, 100, 30);
        background.setBounds (0, 0, 1030, 242);
        
        uname.setBounds (500, 300, 100, 25);
        unum.setBounds (500, 400, 100, 25);
        upass.setBounds (500, 350, 100, 25);
		 lusn.setBounds (400,300, 100, 25);
        lpass.setBounds (400, 350, 100, 25);
        Inum.setBounds (400, 400, 100, 25);

		sign.setFont(new Font("Comic sans",Font.PLAIN,15));
		sign.setBackground(Color.decode("#95CADB"));
	    sign.setFocusable(false);
		cancel.setFont(new Font("Comic sans",Font.PLAIN,15));
		cancel.setBackground(Color.decode("#95CADB"));
	    cancel.setFocusable(false);
		frame.setLocationRelativeTo(null);//to center screen gui
        frame.setLayout (null);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible (true); 
    }        
	
	

    public void actionPerformed(ActionEvent e) { 
	if(e.getSource()==sign){
	String t1 = uname.getText(); // User Name
                String t2 = upass.getText(); // Email
                String t3 = unum.getText(); // Email
             
         try {
                       File file = new File("D:\\meher\\Order.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);

                           

                            pw.println("NAGAD Number : "+t1);
					
                            pw.println("Name : "+t3);
                            pw.println(t3+" We received your order!!!");
                           
             
                            pw.close();

                        } catch (Exception ex) {
                            System.out.print(ex);
                        }

                      
			
					showMessageDialog(null, "Your order is received!","Aegro",JOptionPane.PLAIN_MESSAGE);
		new Order();
	frame.setVisible(false);
	}else if (e.getSource()== cancel){
new Order	();
	frame.setVisible(false);}

	
}}