package ui;

import models.Chale_Item;
import dao.Chale_ItemDAO;

import DatabaseConnection.Database;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Chale_ItemForm extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField codChaleField;
    private JTextField nomeItemField;
    private JButton saveButton;

    public Chale_ItemForm() {
        setTitle("Cadastro de Chale_Item");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        codChaleField = new JTextField();
        nomeItemField = new JTextField();
        saveButton = new JButton("Salvar");

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codChale = Integer.parseInt(codChaleField.getText());
                    String nomeItem = nomeItemField.getText();

                    if (nomeItem.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "O nome do item não pode estar vazio.");
                        return;
                    }

                    Chale_Item chaleItem = new Chale_Item(codChale, nomeItem);
                    Chale_ItemDAO chaleItemDAO = new Chale_ItemDAO(Database.getConnection());
                    chaleItemDAO.save(chaleItem);
                    JOptionPane.showMessageDialog(null, "Chale_Item salvo com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar Chale_Item: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato: " + ex.getMessage());
                }
            }
        });
    }

    private void addComponents() {
        JLabel codChaleLabel = new JLabel("Código do Chale:");
        JLabel nomeItemLabel = new JLabel("Nome do Item:");

        codChaleLabel.setBounds(20, 20, 150, 25);
        codChaleField.setBounds(180, 20, 200, 25);
        nomeItemLabel.setBounds(20, 60, 150, 25);
        nomeItemField.setBounds(180, 60, 200, 25);
        saveButton.setBounds(150, 100, 100, 30);

        add(codChaleLabel);
        add(codChaleField);
        add(nomeItemLabel);
        add(nomeItemField);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Chale_ItemForm().setVisible(true);
        });
    }
}
