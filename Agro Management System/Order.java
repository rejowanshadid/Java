
import java.awt.event.*;  
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Order implements ActionListener{  
    
	 JButton  bk,vi,na;
   
	JFrame frame;
	 ImageIcon img;
 JLabel lusn;
   public Order(){  

		 
        //create frame
		frame = new JFrame ("Aegro");
        //construct components
		bk = new JButton("");
		na = new JButton("");
		vi = new JButton("");
		bk.setText("WHEAT - 70TK/KG");
		bk.setHorizontalTextPosition(JButton.CENTER);
		bk.setVerticalTextPosition(JButton.CENTER);
		bk.setFont(new Font("Montserrat",Font.BOLD,40));
		na.setText("RICE - 80TK/KG");
		na.setHorizontalTextPosition(JButton.CENTER);
		na.setVerticalTextPosition(JButton.CENTER);
		na.setFont(new Font("Montserrat",Font.BOLD,40));
        vi.setText("CORN - 90TK/KG");
		vi.setHorizontalTextPosition(JButton.CENTER);
		vi.setVerticalTextPosition(JButton.CENTER);
		vi.setFont(new Font("Montserrat",Font.BOLD,40));


		
		//addActionListener
		bk.addActionListener(this);
		na.addActionListener(this);
		vi.addActionListener(this);

        //add components
        frame.add (bk);
        frame.add (vi);
        frame.add (na);
       // frame.add (lusn);
		
		ImageIcon img = new ImageIcon("D:\\meher\\image\\ag.jpg");
		ImageIcon bks = new ImageIcon("D:\\meher\\image\\wheat.png");
		ImageIcon naga = new ImageIcon("D:\\meher\\image\\Ricee.jpg");
		ImageIcon visa = new ImageIcon("D:\\meher\\image\\Corn1.jpg");
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
		
		//frame properties
		//adjust size and set layout
        frame.setSize (1045, 600);		//set component bounds (only needed by Absolute Positioning)
        
        bk.setBounds (250, 50, 500, 130);
        na. setBounds (250, 200, 500, 130);
        vi.setBounds (250, 350, 500, 130);
       // lusn.setBounds (500, 0, 75, 75);
	

		
		frame.setLocationRelativeTo(null);//to center screen gui
        frame.setLayout (null);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible (true); 
    }

    public void actionPerformed(ActionEvent e) { 
	if(e.getSource()==bk){
		showMessageDialog(null, "Wheat is in stock! Price - 70TK/KG","Aegro",JOptionPane.PLAIN_MESSAGE);

	new Paymentoptions();
	frame.setVisible(false);
}
    	else if(e.getSource()== vi)
		{  
			
								showMessageDialog(null, "Corn is in stock! Price - 90TK/KG","Aegro",JOptionPane.PLAIN_MESSAGE);

				new Paymentoptions();
				frame.setVisible(false);

			
		} 
			else if(e.getSource()== na)
		{  
			
				showMessageDialog(null, "Rice is in stock! Price - 80TK/KG","Aegro",JOptionPane.PLAIN_MESSAGE);

			
		
				new Paymentoptions();
		frame.setVisible(false);}
			
		else{
		}	
	}
	
	public static void main(String[] args) {  
	 
		 new Order();
		
	}
	
}