package src.com.loja.repository;

import com.loja.model.Estoque;
import src.com.loja.util.DatabaseConfig;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class EstoqueRepository {
    private final Connection connection;

    public EstoqueRepository() throws SQLException {
        this.connection = DatabaseConfig.getConnection();
    }

    public Estoque buscarProdutoPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM estoque WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estoque(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                );
            }
        }
        return null;
    }

    public void adicionarProduto(Estoque produto) throws SQLException {
        String sql = "INSERT INTO estoque (nome, categoria, preco, quantidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public Map<Long, Estoque> listarProdutos() throws SQLException {
        Map<Long, Estoque> produtos = new HashMap<>();
        String sql = "SELECT * FROM estoque";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Estoque produto = new Estoque(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                );
                produtos.put(produto.getId(), produto);
            }
        }
        return produtos;
    }
}
