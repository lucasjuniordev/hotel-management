package dao;

import DatabaseConnection.Database;
import models.Hospedagem; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDAO {
    public void addHospedagem(Hospedagem hospedagem) throws SQLException {
        String sql = "INSERT INTO Hospedagem (codHospedagem, codChale, codCliente, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, hospedagem.getCodHospedagem());
            pstmt.setInt(2, hospedagem.getCodChale());
            pstmt.setInt(3, hospedagem.getCodCliente());
            pstmt.setString(4, hospedagem.getEstado());
            pstmt.setDate(5, hospedagem.getDataInicio());
            pstmt.setDate(6, hospedagem.getDataFim());
            pstmt.setInt(7, hospedagem.getQtdPessoas());
            pstmt.setDouble(8, hospedagem.getDesconto());
            pstmt.setDouble(9, hospedagem.getValorFinal());
            pstmt.executeUpdate();
        }
    }

    public List<Hospedagem> getHospedagens() throws SQLException {
        List<Hospedagem> hospedagens = new ArrayList<>();
        String sql = "SELECT * FROM Hospedagem";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
                hospedagem.setCodChale(rs.getInt("codChale"));
                hospedagem.setCodCliente(rs.getInt("codCliente"));
                hospedagem.setEstado(rs.getString("estado"));
                hospedagem.setDataInicio(rs.getDate("dataInicio"));
                hospedagem.setDataFim(rs.getDate("dataFim"));
                hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
                hospedagem.setDesconto(rs.getDouble("desconto"));
                hospedagem.setValorFinal(rs.getDouble("valorFinal"));
                hospedagens.add(hospedagem);
            }
        }
        return hospedagens;
    }
}
