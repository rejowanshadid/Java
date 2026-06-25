
import java.awt.event.*;  
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Paymentoptions implements ActionListener{  
    
	 JButton  bk,vi,na;
   
	JFrame frame;
	 ImageIcon img;
 JLabel lusn;
   public Paymentoptions(){  

		 
        //create frame
		frame = new JFrame ("Aegro");
        //construct components
		bk = new JButton("");
		na = new JButton("");
		vi = new JButton("");
   
		//bk.setIcon(img);

		//  lusn = new JLabel ("Price - 4251");
      

		
		//addActionListener

        //add components
        frame.add (bk);
        frame.add (vi);
        frame.add (na);
       // frame.add (lusn);
		
		ImageIcon img = new ImageIcon("D:\\meher\\image\\ag.jpg");
		ImageIcon bks = new ImageIcon("D:\\meher\\image\\bkash.png");
		ImageIcon naga = new ImageIcon("D:\\meher\\image\\nagad.png");
		ImageIcon visa = new ImageIcon("D:\\meher\\image\\mas.jpg");
		
		 frame.setIconImage(img.getImage());
		 bk.setIcon(bks);
		 na.setIcon(naga);
		 vi.setIcon(visa);
		 bk.setFocusable(false);
		 na.setFocusable(false);
		 vi.setFocusable(false);
		 bk.setBackground(Color.white);
		 na.setBackground(Color.white);
		 vi.setBackground(Color.white);







     Container contentPane = frame.getContentPane();

        // Set the background color of the content pane
        contentPane.setBackground(Color.decode("#95CADB")); 




		frame.setResizable(false);
		bk.addActionListener(this);
		vi.addActionListener(this);
		na.addActionListener(this);
		
		//frame properties
		//adjust size and set layout
        frame.setSize (1045, 600);		//set component bounds (only needed by Absolute Positioning)
        
        bk.setBounds (250, 50, 500, 130);
        na. setBounds (250, 200, 500, 130);
        vi.setBounds (250, 350, 500, 130);
        //lusn.setBounds (500, 0, 75, 75);
	

		
		frame.setLocationRelativeTo(null);//to center screen gui
        frame.setLayout (null);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible (true); 
    }        
	
	

    public void actionPerformed(ActionEvent e) { 
	if(e.getSource()==bk){
	new Bkash();
	frame.setVisible(false);}
    	else if(e.getSource()== vi)
		{  
			
				
				new Visa();
				frame.setVisible(false);
			
		} 
			else if(e.getSource()== na)
		{  
			
				
				new Nagad();
				frame.setVisible(false);
			
            
			
	} 	else
			{
	}
	
}}