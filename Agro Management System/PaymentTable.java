import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PaymentTable extends JFrame {
    private JTextArea textArea;

    public PaymentTable() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment List");
        setBounds(100, 100, 800, 510);
        getContentPane().setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            EmployeeFrame f = new EmployeeFrame();
            setVisible(false);
            f.setVisible(true);
        });
        getContentPane().add(backButton, BorderLayout.SOUTH);

        loadDataFromFile(); // Load existing data from file when initializing
        setVisible(true);
    }

    // Method to load data from a text file
    private void loadDataFromFile() {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("payment_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea.setText(data.toString());
    }

    public static void main(String[] args) {
        new PaymentTable();
    }
}