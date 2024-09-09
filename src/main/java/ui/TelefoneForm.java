package ui;

import models.Telefone;
import dao.TelefoneDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelefoneForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField telefoneField;
    private JTextField codClienteField;
    private JTextField tipoTelefoneField;
    private JButton saveButton;

    public TelefoneForm() {
        setTitle("Cadastro de Telefone");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        telefoneField = new JTextField();
        codClienteField = new JTextField();
        tipoTelefoneField = new JTextField();
        saveButton = new JButton("Salvar");

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String telefoneText = telefoneField.getText().trim();
                String codClienteText = codClienteField.getText().trim();
                String tipoTelefone = tipoTelefoneField.getText().trim();

                if (telefoneText.isEmpty() || codClienteText.isEmpty() || tipoTelefone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                    return;
                }

                try {
                    int telefone = Integer.parseInt(telefoneText);
                    int codCliente = Integer.parseInt(codClienteText);

                    Telefone telefoneObj = new Telefone();
                    telefoneObj.setTelefone(telefone);
                    telefoneObj.setCodCliente(codCliente);
                    telefoneObj.setTipoTelefone(tipoTelefone);

                    TelefoneDAO telefoneDAO = new TelefoneDAO();
                    telefoneDAO.addTelefone(telefoneObj);
                    JOptionPane.showMessageDialog(null, "Telefone salvo com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Telefone e Código do Cliente devem ser números válidos.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar telefone: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage());
                }
            }
        });
    }

    private void addComponents() {
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(30, 30, 120, 25);
        add(telefoneLabel);
        telefoneField.setBounds(150, 30, 200, 25);
        add(telefoneField);

        JLabel codClienteLabel = new JLabel("Código do Cliente:");
        codClienteLabel.setBounds(30, 70, 120, 25);
        add(codClienteLabel);
        codClienteField.setBounds(150, 70, 200, 25);
        add(codClienteField);

        JLabel tipoTelefoneLabel = new JLabel("Tipo de Telefone:");
        tipoTelefoneLabel.setBounds(30, 110, 120, 25);
        add(tipoTelefoneLabel);
        tipoTelefoneField.setBounds(150, 110, 200, 25);
        add(tipoTelefoneField);

        saveButton.setBounds(150, 150, 100, 25);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelefoneForm().setVisible(true);
        });
    }
}
