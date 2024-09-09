package ui;

import models.Cliente;
import dao.ClienteDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.text.MaskFormatter;

public class ClienteForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField codClienteField;
    private JTextField nomeClienteField;
    private JTextField rgClienteField;
    private JTextField enderecoClienteField;
    private JTextField bairroClienteField;
    private JTextField cidadeClienteField;
    private JTextField estadoClienteField;
    private JTextField cepClienteField;
    private JTextField telefoneClienteField;
    private JFormattedTextField nascimentoClienteField;
    private JButton saveButton;

    public ClienteForm() {
        setTitle("Cadastro de Cliente");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        codClienteField = new JTextField();
        nomeClienteField = new JTextField();
        rgClienteField = new JTextField();
        enderecoClienteField = new JTextField();
        bairroClienteField = new JTextField();
        cidadeClienteField = new JTextField();
        estadoClienteField = new JTextField();
        cepClienteField = new JTextField();
        telefoneClienteField = new JTextField();

        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            nascimentoClienteField = new JFormattedTextField(dateMask);
            nascimentoClienteField.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        saveButton = new JButton("Salvar");

        addComponents();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setCodCliente(Integer.parseInt(codClienteField.getText()));
                    cliente.setNomeCliente(nomeClienteField.getText());
                    cliente.setRgCliente(rgClienteField.getText());
                    cliente.setEnderecoCliente(enderecoClienteField.getText());
                    cliente.setBairroCliente(bairroClienteField.getText());
                    cliente.setCidadeCliente(cidadeClienteField.getText());
                    cliente.setEstadoCliente(estadoClienteField.getText());
                    cliente.setCEPCliente(cepClienteField.getText());
                    cliente.setTelefoneCliente(telefoneClienteField.getText());

                    String nascimentoText = nascimentoClienteField.getText();
                    if (nascimentoText.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
                        java.util.Date dataUtil = originalFormat.parse(nascimentoText);
                        
                        Date nascimentoCliente = new Date(dataUtil.getTime());
                        cliente.setNascimentoCliente(nascimentoCliente);
                    } else {
                        throw new ParseException("Data inválida. Use o formato dd/MM/yyyy.", 0);
                    }

                    ClienteDAO clienteDAO = new ClienteDAO();
                    clienteDAO.addCliente(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato numérico: " + ex.getMessage());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                }
            }
        });
    }

    private void addComponents() {
        JLabel codClienteLabel = new JLabel("Código do Cliente:");
        codClienteLabel.setBounds(10, 30, 150, 25);
        add(codClienteLabel);
        codClienteField.setBounds(170, 30, 300, 25);
        add(codClienteField);

        JLabel nomeClienteLabel = new JLabel("Nome:");
        nomeClienteLabel.setBounds(10, 70, 150, 25);
        add(nomeClienteLabel);
        nomeClienteField.setBounds(170, 70, 300, 25);
        add(nomeClienteField);

        JLabel rgClienteLabel = new JLabel("RG:");
        rgClienteLabel.setBounds(10, 110, 150, 25);
        add(rgClienteLabel);
        rgClienteField.setBounds(170, 110, 300, 25);
        add(rgClienteField);

        JLabel enderecoClienteLabel = new JLabel("Endereço:");
        enderecoClienteLabel.setBounds(10, 150, 150, 25);
        add(enderecoClienteLabel);
        enderecoClienteField.setBounds(170, 150, 300, 25);
        add(enderecoClienteField);

        JLabel bairroClienteLabel = new JLabel("Bairro:");
        bairroClienteLabel.setBounds(10, 190, 150, 25);
        add(bairroClienteLabel);
        bairroClienteField.setBounds(170, 190, 300, 25);
        add(bairroClienteField);

        JLabel cidadeClienteLabel = new JLabel("Cidade:");
        cidadeClienteLabel.setBounds(10, 230, 150, 25);
        add(cidadeClienteLabel);
        cidadeClienteField.setBounds(170, 230, 300, 25);
        add(cidadeClienteField);

        JLabel estadoClienteLabel = new JLabel("Estado:");
        estadoClienteLabel.setBounds(10, 270, 150, 25);
        add(estadoClienteLabel);
        estadoClienteField.setBounds(170, 270, 300, 25);
        add(estadoClienteField);

        JLabel cepClienteLabel = new JLabel("CEP:");
        cepClienteLabel.setBounds(10, 310, 150, 25);
        add(cepClienteLabel);
        cepClienteField.setBounds(170, 310, 300, 25);
        add(cepClienteField);

        JLabel telefoneClienteLabel = new JLabel("Telefone:");
        telefoneClienteLabel.setBounds(10, 350, 150, 25);
        add(telefoneClienteLabel);
        telefoneClienteField.setBounds(170, 350, 300, 25);
        add(telefoneClienteField);

        JLabel nascimentoClienteLabel = new JLabel("Nascimento (dd/MM/yyyy):");
        nascimentoClienteLabel.setBounds(10, 390, 150, 25);
        add(nascimentoClienteLabel);
        nascimentoClienteField.setBounds(170, 390, 300, 25);
        add(nascimentoClienteField);

        saveButton.setBounds(200, 450, 100, 25);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClienteForm().setVisible(true);
        });
    }
}
