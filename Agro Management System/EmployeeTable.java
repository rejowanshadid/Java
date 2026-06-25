import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EmployeeTable extends JFrame {
    private DefaultTableModel model;
    private JTable employeeTable;

    public EmployeeTable() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee List");
        setBounds(100, 100, 800, 510);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        String[] columns = {"Name", "ID", "Position", "Contact No"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        employeeTable = new JTable(model);
        employeeTable.setBackground(Color.GRAY);
        employeeTable.setForeground(Color.BLACK);
        employeeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        employeeTable.setGridColor(Color.WHITE);

        JScrollPane pane = new JScrollPane(employeeTable);
        pane.setForeground(Color.BLACK);
        pane.setBackground(Color.WHITE);
        pane.setBounds(20, 10, 600, 310);
        getContentPane().add(pane);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add button logic
                String name = JOptionPane.showInputDialog("Enter Name:");
                String id = JOptionPane.showInputDialog("Enter ID:");
                String position = JOptionPane.showInputDialog("Enter Position:");
                String contactNo = JOptionPane.showInputDialog("Enter Contact No:");
                model.addRow(new Object[]{name, id, position, contactNo});
                saveDataToFile();
            }
        });
        addButton.setBounds(650, 50, 100, 30);
        getContentPane().add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete button logic
                int selectedRow = employeeTable.getSelectedRow();
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
                OwnerFrame f = new OwnerFrame();
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("employee_data.txt"))) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
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
        new EmployeeTable();
    }
}
