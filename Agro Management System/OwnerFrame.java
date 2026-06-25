import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OwnerFrame extends JFrame implements ActionListener {
    private JButton viewEmployeeButton;
    private JButton viewCustomerButton;
    private JButton viewOwnerButton, viewProfileButton;
    private JButton viewOrderButton, viewPaymentButton;
    private JPanel panel;

    public OwnerFrame() {
        super("Owner Frame");
        this.setSize(800, 510);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a JLabel to hold the background image
        JLabel background = new JLabel(new ImageIcon("background.png"));
        background.setLayout(new BorderLayout());

        // Creating a JPanel to hold the buttons
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        // Adding buttons to the panel
        viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(620, 10, 150, 40);
        viewProfileButton.setBackground(new Color(0, 102, 204));
        viewProfileButton.addActionListener(this);
        panel.add(viewProfileButton);

        viewCustomerButton = new JButton("Customer List");
        viewCustomerButton.setBounds(515, 285, 120, 40);
        viewCustomerButton.setBackground(new Color(204, 204, 0));
        viewCustomerButton.addActionListener(this);
        panel.add(viewCustomerButton);

        viewOwnerButton = new JButton("Owner List");
        viewOwnerButton.setBounds(655, 355, 120, 40);
        viewOwnerButton.setBackground(new Color(51, 204, 0));
        viewOwnerButton.addActionListener(this);
        panel.add(viewOwnerButton);

        viewOrderButton = new JButton("Order List");
        viewOrderButton.setBounds(655, 420, 120, 40);
        viewOrderButton.setBackground(new Color(153, 0, 255));
        viewOrderButton.addActionListener(this);
        panel.add(viewOrderButton);

        viewPaymentButton = new JButton("Payment List");
        viewPaymentButton.setBounds(515, 355, 120, 40);
        viewPaymentButton.setBackground(new Color(255, 204, 0));
        viewPaymentButton.addActionListener(this);
        panel.add(viewPaymentButton);

        viewEmployeeButton = new JButton("Employee List");
        viewEmployeeButton.setBounds(515, 420, 120, 40);
        viewEmployeeButton.setBackground(new Color(0, 204, 155));
        viewEmployeeButton.addActionListener(this);
        panel.add(viewEmployeeButton);

        // Adding the panel to the background label
        background.add(panel);

        // Adding the background label to the frame
        this.setContentPane(background);
    }

    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();

        if (command.equals(viewProfileButton.getText())) {
            OwnerInfo ot=new OwnerInfo();
            this.setVisible(false);
            ot.setVisible(true);

        }

        if (command.equals(viewEmployeeButton.getText())) {
            EmployeeTable et= new EmployeeTable();
            this.setVisible(false);
            et.setVisible(true);
        }

        if(command.equals(viewCustomerButton.getText())) {
            CustomerTabler ct= new CustomerTabler();
            this.setVisible(false);
            ct.setVisible(true);
        }

        if(command.equals(viewOwnerButton.getText())) {
            JOptionPane.showMessageDialog(this, "Viewing Owner List", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

        if(command.equals(viewOrderButton.getText())) {
            OrderTabler ot= new OrderTabler();
            this.setVisible(false);
            ot.setVisible(true);
        }

        /*
        if(command.equals(viewOrderLineButton.getText())) {
            JOptionPane.showMessageDialog(this, "Viewing Order Line", "Message", JOptionPane.INFORMATION_MESSAGE);
        }*/
        if(command.equals(viewPaymentButton.getText())) {
            PaymentTabler pt= new PaymentTabler();
            this.setVisible(false);
            pt.setVisible(true);
        }




    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OwnerFrame ownerFrame = new OwnerFrame();
            ownerFrame.setVisible(true);
        });
    }
}
