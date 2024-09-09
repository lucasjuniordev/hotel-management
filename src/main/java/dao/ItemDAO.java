package dao;

import DatabaseConnection.Database;
import models.Item; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public void addItem(Item item) throws SQLException {
        String sql = "INSERT INTO Item (nomeItem, descricaoItem) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getNomeItem());
            pstmt.setString(2, item.getDescricaoItem());
            pstmt.executeUpdate();
        }
    }

    public List<Item> getItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM Item";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Item item = new Item();
                item.setNomeItem(rs.getString("nomeItem"));
                item.setDescricaoItem(rs.getString("descricaoItem"));
                items.add(item);
            }
        }
        return items;
    }
}
