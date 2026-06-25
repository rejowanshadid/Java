import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmpLogin extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1;
    JButton b1, b2;
    JPasswordField pa1;
    JPanel P1;

    public EmpLogin() {
        this.setTitle("You are interacting as Employee");
        this.setSize(750, 510);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon(getClass().getResource("/image/icon.png"));
        this.setIconImage(img.getImage());

        // creating panel
        P1 = new JPanel();
        P1.setBounds(0, 0, 750, 500);
        P1.setLayout(null);

        // labels
        l1 = new JLabel("User name ");
        l1.setFont(new Font("Georgia", Font.PLAIN, 16));
        l1.setForeground(Color.white);
        l1.setBounds(450, 140, 250, 20);
        P1.add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Georgia", Font.PLAIN, 16));
        t1.setForeground(Color.black);
        t1.setBounds(450, 170, 225, 27);
        P1.add(t1);

        // password
        l2 = new JLabel("Password ");
        l2.setFont(new Font("Georgia", Font.PLAIN, 16));
        l2.setForeground(Color.white);
        l2.setBounds(450, 215, 210, 20);
        P1.add(l2);

        pa1 = new JPasswordField();
        pa1.setEchoChar('*');
        pa1.setFont(new Font("Georgia", Font.PLAIN, 16));
        pa1.setBounds(450, 245, 225, 27);
        P1.add(pa1);

        // back button
        b1 = new JButton("Back");
        b1.setFont(new Font("Georgia", Font.PLAIN, 16));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(210, 4, 45));
        b1.setBounds(450, 358, 225, 27);
        b1.addActionListener(this);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        P1.add(b1);

        // sign-in button
        b2 = new JButton("Sign in");
        b2.setFont(new Font("Georgia", Font.PLAIN, 16));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(118, 194, 175));
        b2.setBounds(450, 310, 225, 27);
        b2.addActionListener(this);
        b2.setFocusable(false);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        P1.add(b2);

        // image
        l3 = new JLabel(new ImageIcon(getClass().getResource("/image/login.png")));
        l3.setBounds(0, 0, 750, 500);
        P1.add(l3);

        this.add(P1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // back button
        if (ae.getSource() == b1) {
            Homepage homepage = new Homepage();
            this.setVisible(false);
            homepage.setVisible(true);
        }

        else if (ae.getSource() == b2) {
            if (t1.getText().length() <= 0 || pa1.getPassword().length <= 0) {
                JOptionPane.showMessageDialog(this, "Fill all information");
            } else {
                try {
                    String userNameS = "Name        :  " + t1.getText();
                    String passwordS = "Password  :  " + new String(pa1.getPassword());

                    BufferedReader reader = new BufferedReader(new FileReader("data\\empData.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get("data\\empData.txt")).get(i);

                        if (line.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get("data\\empData.txt")).get((i + 1));

                            if (line2.equals(passwordS)) {
                                JOptionPane.showMessageDialog(null, "Login Successful.");

                                EmployeeFrame ef=new EmployeeFrame();
                                this.setVisible(false);
								ef.setVisible(true);

                                String line3 = Files.readAllLines(Paths.get("data\\empData.txt")).get((i + 2));
                                String line4 = Files.readAllLines(Paths.get("data\\empData.txt")).get((i + 3));
                                String line5 = Files.readAllLines(Paths.get("data\\empData.txt")).get((i + 4));

                                BufferedWriter writer = new BufferedWriter(new FileWriter("data\\login data.txt"));
                                writer.write("" + line);
                                writer.write("\n" + line2);
                                writer.write("\n" + line3);
                                writer.write("\n" + line4);
                                writer.write("\n" + line5);
                                writer.close();

                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Wrong User Name or Password!");
                }
            }
        }
    }

    public static void main(String[] args) {
        new EmpLogin();
    }
}
