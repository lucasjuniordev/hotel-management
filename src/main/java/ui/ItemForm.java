package ui;

import models.Item;
import dao.ItemDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ItemForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nomeItemField;
    private JTextField descricaoItemField;
    private JButton saveButton;

    public ItemForm() {
        setTitle("Cadastro de Item");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        nomeItemField = new JTextField();
        descricaoItemField = new JTextField();
        saveButton = new JButton("Salvar");

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeItem = nomeItemField.getText().trim();
                String descricaoItem = descricaoItemField.getText().trim();

                if (nomeItem.isEmpty() || descricaoItem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome e descrição do item não podem estar vazios.");
                    return;
                }

                try {
                    Item item = new Item();
                    item.setNomeItem(nomeItem);
                    item.setDescricaoItem(descricaoItem);

                    ItemDAO itemDAO = new ItemDAO();
                    itemDAO.addItem(item);
                    JOptionPane.showMessageDialog(null, "Item salvo com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar item: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage());
                }
            }
        });
    }

    private void addComponents() {
        JLabel nomeItemLabel = new JLabel("Nome do Item:");
        nomeItemLabel.setBounds(30, 30, 120, 25);
        add(nomeItemLabel);
        nomeItemField.setBounds(150, 30, 200, 25);
        add(nomeItemField);

        JLabel descricaoItemLabel = new JLabel("Descrição do Item:");
        descricaoItemLabel.setBounds(30, 70, 120, 25);
        add(descricaoItemLabel);
        descricaoItemField.setBounds(150, 70, 200, 25);
        add(descricaoItemField);

        saveButton.setBounds(150, 110, 100, 25);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ItemForm().setVisible(true);
        });
    }
}
