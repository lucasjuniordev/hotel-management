package ui;

import models.Hospedagem;
import dao.HospedagemDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;

public class HospedagemForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField codHospedagemField;
    private JTextField codChaleField;
    private JTextField codClienteField;
    private JTextField estadoField;
    private JFormattedTextField dataInicioField;
    private JFormattedTextField dataFimField;
    private JTextField qtdPessoasField;
    private JTextField descontoField;
    private JTextField valorFinalField;
    private JButton saveButton;

    public HospedagemForm() {
        setTitle("Cadastro de Hospedagem");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        codHospedagemField = new JTextField();
        codChaleField = new JTextField();
        codClienteField = new JTextField();
        estadoField = new JTextField();
        qtdPessoasField = new JTextField();
        descontoField = new JTextField();
        valorFinalField = new JTextField();
        saveButton = new JButton("Salvar");

        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dataInicioField = new JFormattedTextField(dateMask);
            dataFimField = new JFormattedTextField(dateMask);
            dataInicioField.setColumns(10);
            dataFimField.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Hospedagem hospedagem = new Hospedagem();
                    hospedagem.setCodHospedagem(Integer.parseInt(codHospedagemField.getText()));
                    hospedagem.setCodChale(Integer.parseInt(codChaleField.getText()));
                    hospedagem.setCodCliente(Integer.parseInt(codClienteField.getText()));
                    hospedagem.setEstado(estadoField.getText());

                    String dataInicioText = dataInicioField.getText();
                    String dataFimText = dataFimField.getText();
                    SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");

                    if (dataInicioText.matches("\\d{2}/\\d{2}/\\d{4}") && dataFimText.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        java.util.Date dataInicioUtil = originalFormat.parse(dataInicioText);
                        java.util.Date dataFimUtil = originalFormat.parse(dataFimText);
                        
                        hospedagem.setDataInicio(new Date(dataInicioUtil.getTime()));
                        hospedagem.setDataFim(new Date(dataFimUtil.getTime()));
                    } else {
                        throw new ParseException("Datas inválidas. Use o formato dd/MM/yyyy.", 0);
                    }
                    
                    hospedagem.setQtdPessoas(Integer.parseInt(qtdPessoasField.getText()));
                    hospedagem.setDesconto(Double.parseDouble(descontoField.getText()));
                    hospedagem.setValorFinal(Double.parseDouble(valorFinalField.getText()));

                    HospedagemDAO hospedagemDAO = new HospedagemDAO();
                    hospedagemDAO.addHospedagem(hospedagem);
                    JOptionPane.showMessageDialog(null, "Hospedagem salva com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar hospedagem: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato numérico: " + ex.getMessage());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                }
            }
        });
    }

    private void addComponents() {
        JLabel codHospedagemLabel = new JLabel("Código de Hospedagem:");
        codHospedagemLabel.setBounds(10, 30, 150, 25);
        add(codHospedagemLabel);
        codHospedagemField.setBounds(170, 30, 200, 25);
        add(codHospedagemField);

        JLabel codChaleLabel = new JLabel("Código do Chalé:");
        codChaleLabel.setBounds(10, 70, 150, 25);
        add(codChaleLabel);
        codChaleField.setBounds(170, 70, 200, 25);
        add(codChaleField);

        JLabel codClienteLabel = new JLabel("Código do Cliente:");
        codClienteLabel.setBounds(10, 110, 150, 25);
        add(codClienteLabel);
        codClienteField.setBounds(170, 110, 200, 25);
        add(codClienteField);

        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setBounds(10, 150, 150, 25);
        add(estadoLabel);
        estadoField.setBounds(170, 150, 200, 25);
        add(estadoField);

        JLabel dataInicioLabel = new JLabel("Data Início (dd/MM/yyyy):");
        dataInicioLabel.setBounds(10, 190, 150, 25);
        add(dataInicioLabel);
        dataInicioField.setBounds(170, 190, 200, 25);
        add(dataInicioField);

        JLabel dataFimLabel = new JLabel("Data Fim (dd/MM/yyyy):");
        dataFimLabel.setBounds(10, 230, 150, 25);
        add(dataFimLabel);
        dataFimField.setBounds(170, 230, 200, 25);
        add(dataFimField);

        JLabel qtdPessoasLabel = new JLabel("Quantidade de Pessoas:");
        qtdPessoasLabel.setBounds(10, 270, 150, 25);
        add(qtdPessoasLabel);
        qtdPessoasField.setBounds(170, 270, 200, 25);
        add(qtdPessoasField);

        JLabel descontoLabel = new JLabel("Desconto:");
        descontoLabel.setBounds(10, 310, 150, 25);
        add(descontoLabel);
        descontoField.setBounds(170, 310, 200, 25);
        add(descontoField);

        JLabel valorFinalLabel = new JLabel("Valor Final:");
        valorFinalLabel.setBounds(10, 350, 150, 25);
        add(valorFinalLabel);
        valorFinalField.setBounds(170, 350, 200, 25);
        add(valorFinalField);

        saveButton.setBounds(150, 400, 100, 25);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HospedagemForm().setVisible(true);
        });
    }
}
