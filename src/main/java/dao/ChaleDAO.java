package dao;
	
import DatabaseConnection.Database;
import models.Chale;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChaleDAO {

    public void addChale(Chale chale) throws SQLException {
        String sql = "INSERT INTO Chale (codChale, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, chale.getCodChale());
            pstmt.setString(2, chale.getLocalizacao());
            pstmt.setInt(3, chale.getCapacidade());
            pstmt.setDouble(4, chale.getValorAltaEstacao());
            pstmt.setDouble(5, chale.getValorBaixaEstacao());
            pstmt.executeUpdate();
        }
    }

    public List<Chale> getChales() throws SQLException {
        List<Chale> chales = new ArrayList<>();
        String sql = "SELECT * FROM Chale";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Chale chale = new Chale();
                chale.setCodChale(rs.getInt("codChale"));
                chale.setLocalizacao(rs.getString("localizacao"));
                chale.setCapacidade(rs.getInt("capacidade"));
                chale.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
                chale.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
                chales.add(chale);
            }
        }
        return chales;
    }

    public Chale getChale(int codChale) throws SQLException {
        String sql = "SELECT * FROM Chale WHERE codChale = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codChale);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Chale chale = new Chale();
                    chale.setCodChale(rs.getInt("codChale"));
                    chale.setLocalizacao(rs.getString("localizacao"));
                    chale.setCapacidade(rs.getInt("capacidade"));
                    chale.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
                    chale.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
                    return chale;
                }
            }
        }
        return null;
    }

    public void updateChale(Chale chale) throws SQLException {
        String sql = "UPDATE Chale SET localizacao = ?, capacidade = ?, valorAltaEstacao = ?, valorBaixaEstacao = ? WHERE codChale = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, chale.getLocalizacao());
            pstmt.setInt(2, chale.getCapacidade());
            pstmt.setDouble(3, chale.getValorAltaEstacao());
            pstmt.setDouble(4, chale.getValorBaixaEstacao());
            pstmt.setInt(5, chale.getCodChale());
            pstmt.executeUpdate();
        }
    }

    public void deleteChale(int codChale) throws SQLException {
        String sql = "DELETE FROM Chale WHERE codChale = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codChale);
            pstmt.executeUpdate();
        }
    }
}
