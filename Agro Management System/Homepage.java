import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener {
    
    JLabel l1, l2;
    JButton exitB, ownerB, empB, cusB;
    JPanel p1;
    ImageIcon i1;
    
    public Homepage() {
        this.setTitle(" Let's Get Started ");
        this.setSize(750, 510);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image = new ImageIcon(getClass().getResource("/image/icon.png"));
        this.setIconImage(image.getImage());
        
        // Panel
        p1 = new JPanel();
        p1.setBounds(0, 0, 750, 500);
        p1.setLayout(null);
		
		//label
		l2 = new JLabel("Click to Log in;");
		l2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,22));
		l2.setForeground(new Color(204, 255, 204));
		l2.setBounds(470,110,500,28);
		p1.add(l2);
        
        // Exit button
        exitB = new JButton("Exit");
        exitB.setBounds(470, 300, 180, 36);
        exitB.setFont(new Font("Georgia", Font.PLAIN, 23));
        exitB.setForeground(Color.white);
        exitB.setBackground(new Color(210, 4, 45));
        exitB.addActionListener(this);
        exitB.setFocusable(false);
        exitB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(exitB);  
        
        // Owner button
        ownerB = new JButton("Owner");
        ownerB.setBounds(470, 250, 180, 36);
        ownerB.setFont(new Font("Georgia", Font.PLAIN, 23));
        ownerB.setForeground(Color.white);
        ownerB.setBackground(new Color(118, 194, 175));
        ownerB.addActionListener(this);
        ownerB.setFocusable(false);
        ownerB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(ownerB);  
        
        // Employee button
        empB = new JButton("Employee");
        empB.setBounds(470, 200, 180, 36);
        empB.setFont(new Font("Georgia", Font.PLAIN, 23));
        empB.setForeground(Color.white);
        empB.setBackground(new Color(118, 194, 175));
        empB.addActionListener(this);
        empB.setFocusable(false);
        empB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(empB);  
        
        // Customer button
        cusB = new JButton("Customer");
        cusB.setBounds(470, 150, 180, 36);
        cusB.setFont(new Font("Georgia", Font.PLAIN, 23));
        cusB.setForeground(Color.white);
        cusB.setBackground(new Color(118, 194, 175));
        cusB.addActionListener(this);
        cusB.setFocusable(false);
        cusB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(cusB);  
        
        // Homepage image
        l1 = new JLabel(new ImageIcon(getClass().getResource("/image/homepage.png")));
        l1.setBounds(0, 0, 750, 500);
        p1.add(l1);
        
        this.add(p1);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == exitB) {
            this.dispose();
        } else if (e.getSource() == ownerB) {
            //this.dispose();
            OwnerLogin ol = new OwnerLogin();
            this.setVisible(false);
            ol.setVisible(true);
        } else if (e.getSource() == empB) {
            // this.dispose(); 
            EmpLogin el = new EmpLogin();
            this.setVisible(false);
            el.setVisible(true);
        } else if (e.getSource() == cusB) {
            // this.dispose(); 
             CusLogin cl = new CusLogin();
             this.setVisible(false);
             cl.setVisible(true);
        }  
    }
 
    public static void main(String[] args) {
        
		new Homepage();
		
    }
}
