package dao;

import models.Chale_Item;
import java.sql.*;

public class Chale_ItemDAO {
    private Connection connection;

    public Chale_ItemDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Chale_Item chale_item) throws SQLException {
        String sql = "INSERT INTO Chale_Item (codChale, nomeItem) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, chale_item.getCodChale());
            stmt.setString(2, chale_item.getNomeItem());
            stmt.executeUpdate();
        }
    }

    public Chale_Item find(int codChale, String nomeItem) throws SQLException {
        String sql = "SELECT * FROM Chale_Item WHERE codChale = ? AND nomeItem = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codChale);
            stmt.setString(2, nomeItem);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Chale_Item(rs.getInt("codChale"), rs.getString("nomeItem"));
            }
        }
        return null;
    }

    public void update(Chale_Item chale_item) throws SQLException {
        String sql = "UPDATE Chale_Item SET nomeItem = ? WHERE codChale = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, chale_item.getNomeItem());
            stmt.setInt(2, chale_item.getCodChale());
            stmt.executeUpdate();
        }
    }

    public void delete(int codChale, String nomeItem) throws SQLException {
        String sql = "DELETE FROM Chale_Item WHERE codChale = ? AND nomeItem = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codChale);
            stmt.setString(2, nomeItem);
            stmt.executeUpdate();
        }
    }
}
