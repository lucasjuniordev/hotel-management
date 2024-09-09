package dao;

import models.Hospedagem_Servico;
import java.sql.*;

public class Hospedagem_ServicoDAO {
    private Connection connection;

    public Hospedagem_ServicoDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Hospedagem_Servico hospedagem_servico) throws SQLException {
        String sql = "INSERT INTO Hospedagem_Servico (codHospedagem, dataServico, codServico, valorServico) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, hospedagem_servico.getCodHospedagem());
            stmt.setDate(2, hospedagem_servico.getDataServico());
            stmt.setInt(3, hospedagem_servico.getCodServico());
            stmt.setDouble(4, hospedagem_servico.getValorServico());
            stmt.executeUpdate();
        }
    }

    public Hospedagem_Servico find(int codHospedagem, Date dataServico, int codServico) throws SQLException {
        String sql = "SELECT * FROM Hospedagem_Servico WHERE codHospedagem = ? AND dataServico = ? AND codServico = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codHospedagem);
            stmt.setDate(2, dataServico);
            stmt.setInt(3, codServico);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Hospedagem_Servico(rs.getInt("codHospedagem"), rs.getDate("dataServico"), rs.getInt("codServico"), rs.getDouble("valorServico"));
            }
        }
        return null;
    }

    public void update(Hospedagem_Servico hospedagem_servico) throws SQLException {
        String sql = "UPDATE Hospedagem_Servico SET valorServico = ? WHERE codHospedagem = ? AND dataServico = ? AND codServico = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, hospedagem_servico.getValorServico());
            stmt.setInt(2, hospedagem_servico.getCodHospedagem());
            stmt.setDate(3, hospedagem_servico.getDataServico());
            stmt.setInt(4, hospedagem_servico.getCodServico());
            stmt.executeUpdate();
        }
    }

    public void delete(int codHospedagem, Date dataServico, int codServico) throws SQLException {
        String sql = "DELETE FROM Hospedagem_Servico WHERE codHospedagem = ? AND dataServico = ? AND codServico = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codHospedagem);
            stmt.setDate(2, dataServico);
            stmt.setInt(3, codServico);
            stmt.executeUpdate();
        }
    }
}
