package ui;

import models.Servico;
import dao.ServicoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ServicoForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField codServicoField;
    private JTextField nomeServicoField;
    private JTextField valorServicoField;
    private JButton saveButton;

    public ServicoForm() {
        setTitle("Cadastro de Serviço");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        codServicoField = new JTextField();
        nomeServicoField = new JTextField();
        valorServicoField = new JTextField();
        saveButton = new JButton("Salvar");

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codServicoText = codServicoField.getText().trim();
                String nomeServico = nomeServicoField.getText().trim();
                String valorServicoText = valorServicoField.getText().trim();

                if (codServicoText.isEmpty() || nomeServico.isEmpty() || valorServicoText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                    return;
                }

                try {
                    int codServico = Integer.parseInt(codServicoText);
                    double valorServico = Double.parseDouble(valorServicoText);

                    Servico servico = new Servico();
                    servico.setCodServico(codServico);
                    servico.setNomeServico(nomeServico);
                    servico.setValorServico(valorServico);

                    ServicoDAO servicoDAO = new ServicoDAO();
                    servicoDAO.addServico(servico);
                    JOptionPane.showMessageDialog(null, "Serviço salvo com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Código e valor do serviço devem ser números válidos.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar serviço: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage());
                }
            }
        });
    }

    private void addComponents() {
        JLabel codServicoLabel = new JLabel("Código do Serviço:");
        codServicoLabel.setBounds(30, 30, 120, 25);
        add(codServicoLabel);
        codServicoField.setBounds(150, 30, 200, 25);
        add(codServicoField);

        JLabel nomeServicoLabel = new JLabel("Nome do Serviço:");
        nomeServicoLabel.setBounds(30, 70, 120, 25);
        add(nomeServicoLabel);
        nomeServicoField.setBounds(150, 70, 200, 25);
        add(nomeServicoField);

        JLabel valorServicoLabel = new JLabel("Valor do Serviço:");
        valorServicoLabel.setBounds(30, 110, 120, 25);
        add(valorServicoLabel);
        valorServicoField.setBounds(150, 110, 200, 25);
        add(valorServicoField);

        saveButton.setBounds(150, 150, 100, 25);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ServicoForm().setVisible(true);
        });
    }
}
