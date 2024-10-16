/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaproduto;

/**
 *
 * @author luana_gutkneckt
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testarconexaomysql {
      public static void main(String[] args) {
        // Informações de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/sistemaproduto"; // URL de conexão
        String usuario = "root"; // Nome de usuário do banco de dados
        String senha = ""; // Senha do banco de dados
     
        try {
            // Carregar o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Verificar se a conexão foi bem sucedida
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso ao banco de dados MySQL!");
            }
         
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
       
    }
}
