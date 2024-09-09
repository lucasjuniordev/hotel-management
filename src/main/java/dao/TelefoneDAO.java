package dao;

import DatabaseConnection.Database;
import models.Telefone; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {
    public void addTelefone(Telefone telefone) throws SQLException {
        String sql = "INSERT INTO Telefone (telefone, codCliente, tipoTelefone) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, telefone.getTelefone());
            pstmt.setInt(2, telefone.getCodCliente());
            pstmt.setString(3, telefone.getTipoTelefone());
            pstmt.executeUpdate();
        }
    }

    public List<Telefone> getTelefones() throws SQLException {
        List<Telefone> telefones = new ArrayList<>();
        String sql = "SELECT * FROM Telefone";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setTelefone(rs.getInt("telefone"));
                telefone.setCodCliente(rs.getInt("codCliente"));
                telefone.setTipoTelefone(rs.getString("tipoTelefone"));
                telefones.add(telefone);
            }
        }
        return telefones;
    }
}

