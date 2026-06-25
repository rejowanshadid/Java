import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProductTable extends JFrame {
    private DefaultTableModel model;
    private JTable productListTable;

    public ProductTable() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product List");
        setBounds(100, 100, 800, 510);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        String[] columns = {"Product Name", "Description", "Category", "Price"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        productListTable = new JTable(model);
        productListTable.setBackground(Color.GRAY);
        productListTable.setForeground(Color.BLACK);
        productListTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        productListTable.setGridColor(Color.WHITE);

        JScrollPane pane = new JScrollPane(productListTable);
        pane.setForeground(Color.BLACK);
        pane.setBackground(Color.WHITE);
        pane.setBounds(20, 10, 600, 310);
        getContentPane().add(pane);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add button logic
                String productName = JOptionPane.showInputDialog("Enter Product Name:");
                String description = JOptionPane.showInputDialog("Enter Description:");
                String category = JOptionPane.showInputDialog("Enter Category:");
                String price = JOptionPane.showInputDialog("Enter Price:");
                model.addRow(new Object[]{productName, description, category, price});
                saveDataToFile();
            }
        });
        addButton.setBounds(650, 50, 100, 30);
        getContentPane().add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete button logic
                int selectedRow = productListTable.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    saveDataToFile();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
            }
        });
        deleteButton.setBounds(650, 100, 100, 30);
        getContentPane().add(deleteButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeFrame f = new EmployeeFrame();
                setVisible(false);
                f.setVisible(true);
            }
        });
        backButton.setBounds(650, 150, 100, 30);
        getContentPane().add(backButton);

        loadDataFromFile(); // Load existing data from file when initializing
        setVisible(true);
    }

    // Method to save data to a text file
    private void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("product_data.txt"))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.print(model.getValueAt(i, j));
                    if (j < model.getColumnCount() - 1) {
                        writer.print(",");
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load data from a text file
    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("product_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProductTable();
    }
}