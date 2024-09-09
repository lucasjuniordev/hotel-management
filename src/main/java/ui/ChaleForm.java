package ui;

import models.Chale;
import dao.ChaleDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChaleForm extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField codChaleField;
    private JTextField localizacaoField;
    private JTextField capacidadeField;
    private JTextField valorAltaEstacaoField;
    private JTextField valorBaixaEstacaoField;
    private JButton saveButton;

    public ChaleForm() {
        setTitle("Cadastro de Chalé");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        codChaleField = new JTextField();
        localizacaoField = new JTextField();
        capacidadeField = new JTextField();
        valorAltaEstacaoField = new JTextField();
        valorBaixaEstacaoField = new JTextField();
        saveButton = new JButton("Salvar");

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Chale chale = new Chale();
                    chale.setCodChale(Integer.parseInt(codChaleField.getText()));
                    chale.setLocalizacao(localizacaoField.getText());
                    chale.setCapacidade(Integer.parseInt(capacidadeField.getText()));
                    chale.setValorAltaEstacao(Double.parseDouble(valorAltaEstacaoField.getText()));
                    chale.setValorBaixaEstacao(Double.parseDouble(valorBaixaEstacaoField.getText()));

                    ChaleDAO chaleDAO = new ChaleDAO();
                    chaleDAO.addChale(chale);
                    JOptionPane.showMessageDialog(null, "Chalé salvo com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar chalé: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato: " + ex.getMessage());
                }
            }
        });
    }

    private void addComponents() {
        JLabel codChaleLabel = new JLabel("Código do Chalé:");
        codChaleLabel.setBounds(30, 30, 120, 25);
        add(codChaleLabel);
        codChaleField.setBounds(150, 30, 200, 25);
        add(codChaleField);

        JLabel localizacaoLabel = new JLabel("Localização:");
        localizacaoLabel.setBounds(30, 70, 120, 25);
        add(localizacaoLabel);
        localizacaoField.setBounds(150, 70, 200, 25);
        add(localizacaoField);

        JLabel capacidadeLabel = new JLabel("Capacidade:");
        capacidadeLabel.setBounds(30, 110, 120, 25);
        add(capacidadeLabel);
        capacidadeField.setBounds(150, 110, 200, 25);
        add(capacidadeField);

        JLabel valorAltaEstacaoLabel = new JLabel("Valor Alta Estação:");
        valorAltaEstacaoLabel.setBounds(30, 150, 120, 25);
        add(valorAltaEstacaoLabel);
        valorAltaEstacaoField.setBounds(150, 150, 200, 25);
        add(valorAltaEstacaoField);

        JLabel valorBaixaEstacaoLabel = new JLabel("Valor Baixa Estação:");
        valorBaixaEstacaoLabel.setBounds(30, 190, 120, 25);
        add(valorBaixaEstacaoLabel);
        valorBaixaEstacaoField.setBounds(150, 190, 200, 25);
        add(valorBaixaEstacaoField);

        saveButton.setBounds(150, 230, 100, 25);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChaleForm().setVisible(true);
        });
    }
}
