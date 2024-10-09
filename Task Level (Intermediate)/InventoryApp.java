import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventoryApp {
    private JFrame frame;
    private JTextField nameField;
    private JTextField quantityField;
    private DefaultTableModel tableModel;
    private JTable itemTable;
    public InventoryApp() {
        frame = new JFrame("Inventory Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout());
        nameField = new JTextField(10);
        quantityField = new JTextField(20);
        String[] columnNames = {"Roll Number", "Student Name",};
        tableModel = new DefaultTableModel(columnNames, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JPanel panel = new JPanel();
        panel.add(new JLabel("Roll Number:"));
        panel.add(nameField);
        panel.add(new JLabel("Student Name:"));
        panel.add(quantityField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = nameField.getText();
                String quantity = quantityField.getText();
                if (!itemName.isEmpty() && !quantity.isEmpty()) {
                    tableModel.addRow(new Object[]{itemName, quantity});
                    nameField.setText("");
                    quantityField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter Roll Number and Student Name.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = itemTable.getSelectedRow();
                if (selectedRow != -1) {
                    String itemName = nameField.getText();
                    String quantity = quantityField.getText();
                    if (!itemName.isEmpty() && !quantity.isEmpty()) {
                        tableModel.setValueAt(itemName, selectedRow, 0);
                        tableModel.setValueAt(quantity, selectedRow, 1);
                        nameField.setText("");
                        quantityField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter both name and quantity.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Select an item to update.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = itemTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                    nameField.setText("");
                    quantityField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Select an item to delete.");
                }
            }
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryApp());
    }
}