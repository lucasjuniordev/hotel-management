package dao;

import DatabaseConnection.Database;
import models.Servico; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    public void addServico(Servico servico) throws SQLException {
        String sql = "INSERT INTO Servico (codServico, nomeServico, valorServico) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, servico.getCodServico());
            pstmt.setString(2, servico.getNomeServico());
            pstmt.setDouble(3, servico.getValorServico());
            pstmt.executeUpdate();
        }
    }

    public List<Servico> getServicos() throws SQLException {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM Servico";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setCodServico(rs.getInt("codServico"));
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setValorServico(rs.getDouble("valorServico"));
                servicos.add(servico);
            }
        }
        return servicos;
    }
}
