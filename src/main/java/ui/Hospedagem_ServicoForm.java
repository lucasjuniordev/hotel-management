package ui;

import models.Hospedagem_Servico;
import dao.Hospedagem_ServicoDAO;
import DatabaseConnection.Database;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Hospedagem_ServicoForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField codHospedagemField;
    private JFormattedTextField dataServicoField;
    private JTextField codServicoField;
    private JTextField valorServicoField;
    private JButton saveButton;

    public Hospedagem_ServicoForm() {
        setTitle("Cadastro de Hospedagem_Serviço");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        codHospedagemField = new JTextField();
        codServicoField = new JTextField();
        valorServicoField = new JTextField();
        saveButton = new JButton("Salvar");

        // Formato de máscara para a data do serviço
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dataServicoField = new JFormattedTextField(dateMask);
            dataServicoField.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codHospedagem = Integer.parseInt(codHospedagemField.getText());
                    
                    // Conversão da data
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date dataServicoUtil = dateFormat.parse(dataServicoField.getText());
                    Date dataServico = new Date(dataServicoUtil.getTime());

                    int codServico = Integer.parseInt(codServicoField.getText());
                    double valorServico = Double.parseDouble(valorServicoField.getText());

                    if (valorServico < 0) {
                        JOptionPane.showMessageDialog(null, "O valor do serviço não pode ser negativo.");
                        return;
                    }

                    Hospedagem_Servico hospedagem_servico = new Hospedagem_Servico(
                        codHospedagem,
                        dataServico,
                        codServico,
                        valorServico
                    );
                    Hospedagem_ServicoDAO hospedagemServicoDAO = new Hospedagem_ServicoDAO(Database.getConnection());
                    hospedagemServicoDAO.save(hospedagem_servico);
                    JOptionPane.showMessageDialog(null, "Hospedagem_Serviço salvo com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar Hospedagem_Serviço: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato: " + ex.getMessage());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy.");
                }
            }
        });
    }

    private void addComponents() {
        JLabel codHospedagemLabel = new JLabel("Código da Hospedagem:");
        JLabel dataServicoLabel = new JLabel("Data do Serviço (dd/MM/yyyy):");
        JLabel codServicoLabel = new JLabel("Código do Serviço:");
        JLabel valorServicoLabel = new JLabel("Valor do Serviço:");

        codHospedagemLabel.setBounds(20, 20, 180, 25);
        codHospedagemField.setBounds(200, 20, 150, 25);
        dataServicoLabel.setBounds(20, 60, 180, 25);
        dataServicoField.setBounds(200, 60, 150, 25);
        codServicoLabel.setBounds(20, 100, 180, 25);
        codServicoField.setBounds(200, 100, 150, 25);
        valorServicoLabel.setBounds(20, 140, 180, 25);
        valorServicoField.setBounds(200, 140, 150, 25);
        saveButton.setBounds(150, 180, 100, 30);

        add(codHospedagemLabel);
        add(codHospedagemField);
        add(dataServicoLabel);
        add(dataServicoField);
        add(codServicoLabel);
        add(codServicoField);
        add(valorServicoLabel);
        add(valorServicoField);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Hospedagem_ServicoForm().setVisible(true);
        });
    }
}
