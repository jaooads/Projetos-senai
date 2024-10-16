package com.mycompany.sistemaproduto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    // Método para inserir um produto no banco de dados
    public void inserirProduto(Produto produto) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            // Obter a conexão com o banco de dados
            // Supondo que você já configurou a conexão com o MySQL
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaproduto", "root", "");

            // Query de inserção
            String query = "INSERT INTO Produto (codigo, marca, modelo, descricao, preco, qntEstoque) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar o statement
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, produto.getCodigo());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getModelo());
            stmt.setString(4, produto.getDescricao());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(6, produto.getqntEstoque());

            // Executar a inserção
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceções, log, etc.
        } finally {
            // Fechar conexão e recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para atualizar um produto no banco de dados
    /* public void atualizarProduto(Produto produto) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            // Obter a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaproduto", "root", "");

            // Query de atualização
            String query = "UPDATE Produto SET marca=?, modelo=?, descricao=?, preco=?, qntEstoque=? WHERE codigo=?";

            // Preparar o statement
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, produto.getMarca());
            stmt.setString(2, produto.getModelo());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getqntEstoque());
            stmt.setString(6, produto.getCodigo());

            // Executar a atualização
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceções, log, etc.
        } finally {
            // Fechar conexão e recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
    } */
    // Método para buscar um produto por código
    public Produto buscarProduto(String codigo) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Obter a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaproduto", "root", "");

            // Query de busca
            String query = "SELECT * FROM Produto WHERE codigo = ?";

            // Preparar o statement
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, codigo);

            // Executar a consulta
            rs = stmt.executeQuery();

            // Verificar se encontrou algum resultado
            if (rs.next()) {
                // Criar uma instância de Produto com os dados encontrados
                Produto produtoEncontrado = new Produto(
                        rs.getString("codigo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getInt("qntEstoque")
                );

                return produtoEncontrado;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceções, log, etc.
        } finally {
            // Fechar conexão e recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Retorna null se o produto não for encontrado
    }

    public void atualizarProduto(Produto produto) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            // Obter a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaproduto", "root", "");

            // Query de atualização
            String query = "UPDATE Produto SET marca=?, modelo=?, descricao=?, preco=?, qntEstoque=? WHERE codigo=?";

            // Preparar o statement
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, produto.getMarca());
            stmt.setString(2, produto.getModelo());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getqntEstoque());
            stmt.setString(6, produto.getCodigo());

            // Executar a atualização
            stmt.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceções, log, etc.
        } finally {
            // Fechar conexão e recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void excluirProduto(String codigo) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            // Obter a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaproduto", "root", "");

            // Query de exclusão
            String query = "DELETE FROM Produto WHERE codigo=?";

            // Preparar o statement
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, codigo);

            // Executar a exclusão
            stmt.executeUpdate();

            System.out.println("Produto excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceções, log, etc.
        } finally {
            // Fechar conexão e recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
