package dao;

import DatabaseConnection.Database;
import models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void addCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (codCliente, nomeCliente, rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, CEPCliente, nascimentoCliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cliente.getCodCliente());
            pstmt.setString(2, cliente.getNomeCliente());
            pstmt.setString(3, cliente.getRgCliente());
            pstmt.setString(4, cliente.getEnderecoCliente());
            pstmt.setString(5, cliente.getBairroCliente());
            pstmt.setString(6, cliente.getCidadeCliente());
            pstmt.setString(7, cliente.getEstadoCliente());
            pstmt.setString(8, cliente.getCEPCliente());
            pstmt.setDate(9, cliente.getNascimentoCliente());
            pstmt.executeUpdate();
        }
    }

    public List<Cliente> getClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setRgCliente(rs.getString("rgCliente"));
                cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
                cliente.setBairroCliente(rs.getString("bairroCliente"));
                cliente.setCidadeCliente(rs.getString("cidadeCliente"));
                cliente.setEstadoCliente(rs.getString("estadoCliente"));
                cliente.setCEPCliente(rs.getString("CEPCliente"));
                cliente.setNascimentoCliente(rs.getDate("nascimentoCliente"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
